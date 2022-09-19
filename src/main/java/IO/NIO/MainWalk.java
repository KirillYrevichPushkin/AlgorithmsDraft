package IO.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainWalk {

    public static void main(String[] args) {

        try {
            Stream <Path> stream = Files.walk(Paths.get("D:\\IT\\Projects\\Algorithms\\src\\main\\java"));

        stream.forEach(path -> {
            System.out.println(path.getFileName().toString());
        });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
