package Multithread.l3;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {
    CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(i);
            countDownLatch.countDown();
        }
    }
}
