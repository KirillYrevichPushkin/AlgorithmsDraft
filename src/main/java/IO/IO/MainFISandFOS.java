package IO.IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainFISandFOS {
    public static void main(String[] args) {
        File file = new File("src/main/java/IO/IO/temp1.txt");
        System.out.println(file.isFile());
        System.out.println(file.getFreeSpace()/1024/1024);
        System.out.println(file.getTotalSpace()/1024/1024);
        System.out.println(file.getUsableSpace()/1024/1024);


        Path path = file.toPath();
        Path path1 = Paths.get("src/main/java/IO/IO/temp1.txt");
        Path path2 = Paths.get("src/main/java/IO/IO/temp2.txt");

        File file3 = new File("src/main/java/Graph");
        System.out.println(file3.isDirectory());
        String [] s = file3.list();
        for (String st : s ) {
            System.out.println(st);
        }

        FilenameFilter filter = new FilenameFilter() {
            String str = "Main";
            @Override
            public boolean accept(File dir, String name) {

                return name.startsWith(str);
            }
        };

        String [] s2 = file3.list(filter);

        for (String st : s2 ) {
            System.out.println(st);
        }

        System.out.println("fis++++++++++++++");
        FileOutputStream fos = null;

        long t1 = System.currentTimeMillis();

        try(FileInputStream fis = new FileInputStream(path1.toFile())) {
            fos = new FileOutputStream(path2.toFile());
            byte [] buff = new byte[5];
            
            //чтение побайтово
            int readByte;
  //          StringBuilder sb = new StringBuilder();

            //чтение буфером
            while((readByte = fis.read(buff))!=-1){

//                for ( byte b:buff ) {
//                    sb.append(String.valueOf((char)b));
//                }
                //запись в файл буфером
                //если перезаписан не весь буфер - корректируем запись только последних добавленных байтов
                if(readByte==5){
                fos.write(buff);
                }else {
                    fos.write(buff, 0, readByte-1);
                }

            }
            fos.flush();
//            System.out.println(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis()-t1);
    }

}
