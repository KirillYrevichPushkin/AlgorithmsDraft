package IO.IO;

import java.io.*;

public class MainBRandBW {
    public static void main(String[] args) {

        File f1 = new File("src/main/java/IO/IO/temp.txt");
        File f2 = new File("src/main/java/IO/IO/temp2.txt");

        int nChars;
        char [] byf = new char[5];

        long t1 = System.currentTimeMillis();
        try(BufferedReader br = new BufferedReader(new FileReader(f1))) {
            try (Writer bw = new BufferedWriter(new FileWriter(f2))){

                while ((nChars = br.read(byf))!=-1){

                    if(nChars == 5){
                        bw.write(byf);
                    }else {
                        bw.write(byf,0,nChars);
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
