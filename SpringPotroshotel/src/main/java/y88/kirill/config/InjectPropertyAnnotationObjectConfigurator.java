package y88.kirill.config;


import y88.kirill.core.ApplicationContext;
import y88.kirill.annotation.InjectProperty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    private  Map<String, String> propertyMap;

    //@SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        Stream<String> lines = null;
        try {
            lines = new BufferedReader(new FileReader(path)).lines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.propertyMap = lines.map(line -> line.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
    }


    //@SneakyThrows
    @Override
    public void configure(Object t, ApplicationContext context) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);

            if(annotation!=null){
                String value = annotation.value().isEmpty() ? propertyMap.get(field.getName()) :propertyMap.get(annotation.value());

                field.setAccessible(true);
                try {
                    field.set(t,value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
