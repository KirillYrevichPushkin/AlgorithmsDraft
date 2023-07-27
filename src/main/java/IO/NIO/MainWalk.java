package IO.NIO;


import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.Scanners;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class MainWalk {

    public static void main(String[] args) {

//        try {
//            //Stream <Path> stream = Files.walk(Paths.get("D:\\IT\\Projects\\Algorithms\\src\\main\\java"));
//            Stream <Path> stream = Files.walk(Paths.get("src/main/java/IO/NIO"));
//
//        stream.forEach(path -> {
//            System.out.println(path.getFileName().toString());
//        });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            System.out.println(Class.forName("MainFind"));
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(Scanners.SubTypes)
                .forPackage("java.IO.NIO"));

        Set<Class<? extends Object>> allClasses =
                reflections.getSubTypesOf(Object.class);

        System.out.println(allClasses.size());

        for (Class<?> allClass : allClasses) {
            System.out.println(allClass.getName());
        }

    }

}
