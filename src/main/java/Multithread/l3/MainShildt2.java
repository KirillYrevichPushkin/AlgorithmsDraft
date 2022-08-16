package Multithread.l3;

import java.util.concurrent.CountDownLatch;

public class MainShildt2 {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("start");
        new Thread(new MyThread(countDownLatch)).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");


    }

}
