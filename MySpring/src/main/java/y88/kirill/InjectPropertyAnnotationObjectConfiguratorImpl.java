package y88.kirill;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyAnnotationObjectConfiguratorImpl implements ObjectConfigurator {

    Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfiguratorImpl() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Stream<String> lines = bufferedReader.lines();
        this.propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr-> arr[0], arr-> arr[1]));

//        for (Map.Entry<String, String> me: propertiesMap.entrySet()
//             ) {
//            System.out.println(" key = " + me.getKey() + " value = " + me.getValue());
//        }

    }

    @SneakyThrows
    @Override
    public void configure(Object t,ApplicationContext context ) {
        Class<?> implClass = t.getClass();

        for( Field field: implClass.getDeclaredFields()){
            InjectProperty annotation =  field.getAnnotation(InjectProperty.class);

            String value;
            if(annotation != null){
                if(annotation.value().isEmpty()){
                    value = propertiesMap.get(field.getName());
                }else {
                    value = propertiesMap.get(annotation.value());
                }
                field.setAccessible(true);
                field.set(t,value);
            }

        }
    }
}
