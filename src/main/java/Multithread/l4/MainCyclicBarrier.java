package Multithread.l4;

import java.util.concurrent.CyclicBarrier;

public class MainCyclicBarrier {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarAction());
        System.out.println("start Threads");
        new Thread(new MyThread4(cyclicBarrier, "A")).start();
        new Thread(new MyThread4(cyclicBarrier, "B")).start();
        new Thread(new MyThread4(cyclicBarrier, "C")).start();
    }


}
