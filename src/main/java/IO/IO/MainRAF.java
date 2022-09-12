package IO.IO;

import java.io.*;
import java.sql.Time;

public class MainRAF implements Serializable {

    public static void main(String[] args) {

        File f1 = new File("src/main/java/IO/IO/temp1.txt");
        File f2 = new File("src/main/java/IO/IO/temp2.txt");



        int nBytes;
        byte [] byf = new byte[5];

        long t1 = System.currentTimeMillis();
        try {
            RandomAccessFile raf1 = new RandomAccessFile(f1,"rw");
            RandomAccessFile raf2 = new RandomAccessFile(f2,"rw");

            while ((nBytes = raf1.read(byf))!=-1){

                if(nBytes == 5) {
                    raf2.write(byf);
                }else {
                    raf2.write(byf,0,nBytes);
                }


            }

            raf2.close();
            raf1.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-t1);

    }


}
