package Multithread.CallableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyForkJoinTask {
    public static void main(String[] args) {
        List<Index> indices = new ArrayList<>(100000000);
        long createStart = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            indices.add(new Index(i));
        }
        long createEnd = System.currentTimeMillis() - createStart;
        System.out.println("time created = " + createEnd);

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            indices.get(i).indexSqrt = Math.sqrt( indices.get(i).index);
        }
      //  long t2 = System.currentTimeMillis() - t1;
        //System.out.println("Time 1 = " + t2);

      //  long t3 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            indices.get(i).indexTwo = indices.get(i).index*indices.get(i).index;
        }
       // long t4 = System.currentTimeMillis() - t3;
        long t5 = System.currentTimeMillis() - t1;
       // System.out.println("Time 2 = " + t4);
        System.out.println("All Time = " + t5);

        for (int i = 0; i < 10; i++) {
            System.out.println(indices.get(i).toString());
        }


        Callable<Index> c1 = new Callable<>() {
            @Override
            public Index call() throws Exception {
                for (int i = 0; i < 100000000; i++) {
                    indices.get(i).indexSqrt = Math.sqrt( indices.get(i).index);
                }
                return null;
            }
        };

        Callable<Index> c2 = new Callable<Index>() {
            @Override
            public Index call() throws Exception {
                for (int i = 0; i < 100000000; i++) {
                    indices.get(i).indexTwo = indices.get(i).index*indices.get(i).index;
                }
                return null;
            }
        };

        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        long t6 = System.currentTimeMillis();
        forkJoinPool.invokeAll(List.of(c1,c2));
        long t7 = System.currentTimeMillis() - t6;

        System.out.println();
        System.out.println("Time ForkJoin = " + t7);
        for (int i = 0; i < 10; i++) {
            System.out.println(indices.get(i).toString());
        }


    }
}

class Index {
    int index;
    double indexSqrt;
    double indexTwo;

    public Index(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Index{" +
                "index=" + index +
                ", indexSqrt=" + indexSqrt +
                ", indexTwo=" + indexTwo +
                '}';
    }
}
