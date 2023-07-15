package y88.kirill.config;


import y88.kirill.core.ApplicationContext;
import y88.kirill.annotation.InjectByType;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    public void configure(Object t,  ApplicationContext context) {

        for (Field field : t.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(InjectByType.class)){
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                try {
                    field.set(t,object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }




            }
        }

    }
}
