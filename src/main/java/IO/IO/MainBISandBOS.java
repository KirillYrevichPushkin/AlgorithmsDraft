package IO.IO;

import java.io.*;

public class MainBISandBOS {

    public static void main(String[] args) {
        File f1 = new File("src/main/java/IO/IO/temp1.txt");
        File f2 = new File("src/main/java/IO/IO/temp2.txt");



        byte [] buf = new byte[5];
        int nByte;
        long t1 = System.currentTimeMillis();
       try( InputStream bis = new BufferedInputStream(new FileInputStream(f1), 32)) {
           try(OutputStream bos = new BufferedOutputStream(new FileOutputStream(f2),32)){

               while ((nByte = bis.read(buf))!=-1){

                if(nByte == 5){
                    bos.write(buf);
                }else {
                    bos.write(buf,0,nByte);
                    bos.flush();
                }
               }
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
        System.out.println(System.currentTimeMillis()-t1);

    }


}
