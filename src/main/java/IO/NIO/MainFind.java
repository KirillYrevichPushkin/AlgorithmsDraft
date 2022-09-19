package IO.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class MainFind {
    public static void main(String[] args) {

        String nameFind = "JqueR";
//        List<Path> findList = Files.find("D:\\IT\\Projects\\Algorithms\\src\\main\\java",10,
//                (n) ->{
//
//                }).collect(Collectors.toList());

        try {
            List<Path> findList = Files.walk(Path.of("D:\\IT\\Projects\\Algorithms\\src\\main\\java"))
                    .filter( path -> {
                       return (path.toString().toLowerCase()).contains(nameFind.toLowerCase());
                    })
                    .collect(Collectors.toList());

            for (Path p: findList) {
                System.out.println(p);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }





    }


}
