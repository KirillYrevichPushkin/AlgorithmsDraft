package IO.IO;

import java.io.*;

public class MainFRandFW {

    public static void main(String[] args) {

        File f1 = new File("src/main/java/IO/IO/temp1.txt");
        File f2 = new File("src/main/java/IO/IO/temp2.txt");

        int nChars;
        char [] byf = new char[5];

        long t1 = System.currentTimeMillis();
        try(Reader fr = new FileReader(f1)) {
            try (Writer fw = new FileWriter(f2)){

                while ((nChars = fr.read(byf))!=-1){
                    if(nChars==5){
                        fw.write(byf);
                    }else {
                        fw.write(byf,0,nChars);
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
