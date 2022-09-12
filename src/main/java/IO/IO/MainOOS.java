package IO.IO;

import java.io.*;

public class MainOOS {
    public static void main(String[] args) {
        File f1 = new File("src/main/java/IO/IO/MainRAF.java");
        File f2 = new File("src/main/java/IO/IO/temp2.txt");

        int nBytes;
        int arrLength;
        byte [] buf = new byte[5];
        byte [] buf2;

        MyClass myClass = new MyClass("onegjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjh" +
                "/////////////////////////////////////////" +
                "////////////lftrthfdddddddddddddddddddddddddddddddd" +
                "jrsggjaw;weruji843333333333333333333333333333" +
                "sffffffffffffffffffffffffffffffffffffffffffff" +
                "дыпввдудупылплфлклуцщулзщфплщуфллфузпфупщфкуукплупфщукплкщ", 1);
        MainRAF mainRAF = new MainRAF();


        //преобразование сериализуемого объекта в массив байтов
        try(ByteArrayOutputStream b = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(b)){
                oos.writeObject(myClass);
        buf2 = b.toByteArray();
        arrLength = buf2.length;
            System.out.println(arrLength);

            //запись массива байтов сериализуемого класса в файл
            try(ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(f2))) {

                //при записи побайтово, во время чтения из файла вываливается ошибка - примитивный тип данных вместо объекта
                //следовательно запись лучше осуществлять методом writeObject
            //    oos2.write(buf2);


                    oos2.writeObject(myClass);


                } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f2))) {
            MyClass myClass1 = (MyClass) oi.readObject();
            System.out.println(myClass1.getI() + "\n" + myClass1.getS());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}
