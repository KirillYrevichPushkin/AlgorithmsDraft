package org.springframework.beans.factory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.stereotype.Component;
import org.springframework.beans.factory.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class BeanFactory {

    private Map<String, Object> singleton = new HashMap<>();
    private List<BeanPostProcessor> postProcessors = new ArrayList<>();

    public void addPostProcessor(BeanPostProcessor postProcessor){
        postProcessors.add(postProcessor);
    }


    public Object getBean(String nameBean){
        return singleton.get(nameBean);
    }

    public void instantiate(String basePackage){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String path = basePackage.replace('.', '/');
        try {
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()){
                URL resource = resources.nextElement();

                File file = new File(resource.toURI());
                for (File classfile : file.listFiles()){
                    String fileName = classfile.getName();

                    if(fileName.endsWith(".class")){
                        String className = fileName.substring(0,fileName.lastIndexOf("."));

                        Class classObject = Class.forName(basePackage + "." + className);

                        if(classObject.isAnnotationPresent(Component.class)){
                            System.out.println("Component: "  + classObject);

                            Object instance = classObject.newInstance();
                            String beanName = className.substring(0,1).toLowerCase() + className.substring(1);

                            singleton.put(beanName, instance);

                        }
                        if(classObject.isAnnotationPresent(Service.class)){
                            System.out.println("Service: "  + classObject);
                        }
                    }


                }

            }






        } catch (IOException | URISyntaxException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void populateProperties(){
        System.out.println("==populateProperties");

        for (Object object : singleton.values() ) {
            for(Field field : object.getClass().getDeclaredFields()){
                if(field.isAnnotationPresent(Autowired.class)){

                    for (Object dependency : singleton.values()){
                        if(dependency.getClass().equals(field.getType())){

                            String setterName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);//setPromotionService
                            System.out.println("Setter name = " + setterName);
                            Method setter = null;

                            try {
                                setter = object.getClass().getMethod(setterName, dependency.getClass());
                                setter.invoke(object, dependency);
                            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public void injectBeanNames(){
        for(String name : singleton.keySet()){
            Object bean = singleton.get(name);
            if(bean instanceof BeanNameAware){
                ((BeanNameAware)bean).setBeanName(name);
            }
            if(bean instanceof BeanFactoryAware){
                ((BeanFactoryAware)bean).setFactoryName(this);
            }

        }
    }

    public void initializeBeans(){
//        for (Object bean : singleton.values()) {
//            if(bean instanceof InitializingBean){
//                ((InitializingBean) bean).afterPropertiesSet();
//            }
//        }

        for ( Map.Entry<String,Object> me : singleton.entrySet()) {
            for ( BeanPostProcessor postProcessor : postProcessors  ) {
                postProcessor.postProcessBeforeInitialization(me.getValue(),me.getKey());
            }
            if(me.getValue() instanceof InitializingBean){
                ((InitializingBean) me.getValue()).afterPropertiesSet();
            }
            for ( BeanPostProcessor postProcessor : postProcessors  ) {
                postProcessor.postProcessAfterInitialization(me.getValue(),me.getKey());
            }
        }
    }

    public void injectBeanFactory(){
        for(String name : singleton.keySet()){
            Object bean = singleton.get(name);
            if(bean instanceof BeanFactoryAware){
                ((BeanFactoryAware)bean).setFactoryName(this);
            }
        }
    }


}
