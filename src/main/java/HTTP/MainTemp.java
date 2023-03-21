package HTTP;

import java.text.Collator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainTemp {
      //  static Temp temp;
    public static void main(String[] args) {
        //Temp temp;
      //  System.out.println(Temp.one);
        class Horse{
            public String name;
            public Horse(String n) {
                name = n;
            }
        }
        Object obj = new Horse("Zippo");
        Horse h = (Horse) obj;
        System.out.println(h.name);

        String x = "abc";
        String y = "abc";
        x.concat(y);
        System.out.println(x) ;

        Temp2 t2 = new Temp2(5, "five");
        System.out.println(t2.toString());

        Temp t1 = (Temp)t2;

        System.out.println(t1);

        Temp2 t3 = (Temp2) t1;
        System.out.println(t3.toString());
        int a1 = 1;
        int b1 = 2;


        TempInt c = new TempInt(){
                                @Override
                                public int sum(int a, int b) {
                                    return a+b;
                                }
        } ;

        TempInt c2 = (int a,int b) -> {

            return a + b;
        };

        Stream<Integer> s1 = Stream.of(5,4,3);
        System.out.println(s1.count());

        int k = c.sum(a1, b1);


        long[] a11 = {3,4,5};
        long[] a22 = fix(a11);
        System.out.println("---");
        System.out.println(a11[0] + a11[1] + a11[2]);
        System.out.println("+++");
        System.out.println(a22[0] + a22[1] + a22[2]);
        System.out.println("sssss");

        String s10 = "slip";
        String s20 = fix(s10);
        System.out.println(s10 + " " + s20);


        try {
            Temp.badMethod();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("C");
        }


    }

    static String fix (String s1){
        s1 = s1 + "stream";
        System.out.print(s1 + " ");
        return "stream";
    }

    static long  [] fix (long [] a3){
        a3[1] = 7;
        return a3;
    }

}

 interface TempInt{
    int sum(int a, int b);
}
