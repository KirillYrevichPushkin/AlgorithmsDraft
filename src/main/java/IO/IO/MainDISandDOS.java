package IO.IO;

import java.io.*;

public class MainDISandDOS {

    public static void main(String[] args) {

        File f1 = new File("src/main/java/IO/IO/temp1.txt");
        File f2 = new File("src/main/java/IO/IO/temp2.txt");
        File fileHref = new File("src/main/java/selenium/href.txt");





        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileHref))) {

            //EOFException - т.к. для чтения из файла это не самый хороший вариант использовать этот класс
         //   System.out.println(dis.readUTF());

            String s = dis.readUTF();
            while (s!=null) {
                System.out.println("s " + s);
                s = dis.readUTF();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){
            System.out.println("File end");
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(f2))) {

         //   dos.writeUTF("Пробная строка");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
