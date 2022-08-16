package Multithread.l4;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread4 implements  Runnable{
CyclicBarrier cyclicBarrier;
String name;

    public MyThread4(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "start");
        try {
            cyclicBarrier.await();
            System.out.println(name + "старт после барьера");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }



}
