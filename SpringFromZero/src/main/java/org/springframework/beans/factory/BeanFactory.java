package org.springframework.beans.factory;


import org.springframework.beans.factory.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BeanFactory {
    private Map<String, Object> singleton = new HashMap<>();

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

}
