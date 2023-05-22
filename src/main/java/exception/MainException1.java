package exception;

import org.openjdk.jol.vm.VM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainException1 {

//    public MainException1() {
//        File dir = new File("ss");
//        try {
//            FileInputStream fis = new FileInputStream(dir);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public static void main(String[] args)  {

 //       if(true) throw new RuntimeException("hello? im runtime 0 0 !");

        System.out.println(VM.current().details());

        boolean tr = true;

        Iterator ei;

        ListIterator li;

        CopyOnWriteArrayList f;

        TreeSet ts;

        HashMap p;

        char c = 20;
        System.out.println(c);

        int i = 65536;
        char ic = (char) i;
        char cc = 'o';
        int ii = (int)cc ;
        System.out.println(ic);

        System.out.println(ii);


        int a = 30000;
        byte b = (byte) a;

        System.out.println("b = "  + b);







        try{
            //throw new Exception("one exception");
           // main(args);
           // throw new StackOverflowError();

            throw new RuntimeException("runtime here " ,new IOException("IOException here"));
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("+++");
            e.getLocalizedMessage();
            System.err.println("catch 1");

            if(true) throw new RuntimeException("hello? im runtime!", e  );
            System.err.println("catch 2");
          //  throw e;

        }finally {
            System.err.println("finally 1");
         //     if(true)  throw new RuntimeException("two exception");
            System.err.println("finally 1.1");
        }



        System.err.println("end");



    }

//    public static void main2() {
//        String line; // (1)
//        try {
//            line = "hello"; // (2)
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//
//        System.out.println(line); // (3)
//    }


}
