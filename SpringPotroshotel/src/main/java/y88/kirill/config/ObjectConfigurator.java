package y88.kirill.config;


import y88.kirill.core.ApplicationContext;

//BeanPostProcessor
public interface ObjectConfigurator {

    void configure(Object t, ApplicationContext context);

}
