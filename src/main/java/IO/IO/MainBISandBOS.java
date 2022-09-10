package IO.IO;

import java.io.*;

public class MainBISandBOS {

    public static void main(String[] args) {
        File f1 = new File("src/main/java/IO/IO/temp.txt");
        File f2 = new File("src/main/java/IO/IO/temp2.txt");


        byte [] buf = new byte[5];
        int nbyte;
       try( BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1), 32)) {
           try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2),32)){

               while ((nbyte = bis.read(buf))!=-1){

                if(nbyte == 5){
                    bos.write(buf);
                }else {
                    bos.write(buf,0,nbyte);
                    bos.flush();
                }
               }
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }


    }


}
