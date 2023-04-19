package Multithread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainCB {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new AnotherTask(" Another"));
        System.out.println(Thread.currentThread().getName() + " start");

        new Thread(new TempThread(cyclicBarrier,"T1")).start();
        new Thread(new TempThread(cyclicBarrier,"T2")).start();
        new Thread(new TempThread(cyclicBarrier,"T3")).start();
     //   new Thread(new TempThread(cyclicBarrier,"T4")).start();

//        try {
//
//            cyclicBarrier.await();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }


        System.out.println(Thread.currentThread().getName() + " end");


        
    }
    
}

class TempThread implements Runnable{
    CyclicBarrier cb;
    String name;

    public TempThread(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + name + " start");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(200);
                System.out.println(name + " iter " + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            cb.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(200);
                System.out.println(name + " iter after await " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName() + " " + name + " end");

    }
}

class AnotherTask implements Runnable{

    String name;

    public AnotherTask( String name) {

        this.name = name;
    }



    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + name + " start");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + name + " end");
    }
}
