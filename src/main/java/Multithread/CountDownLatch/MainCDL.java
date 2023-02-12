package Multithread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class MainCDL {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println(Thread.currentThread().getName() + " start");

        new Thread(new CDLTemp(countDownLatch)).start();


        try {
            //ожидание
            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end");

    }


}

class CDLTemp implements Runnable{
    CountDownLatch countDownLatch;

    public CDLTemp(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("countDownLatch.countDown();" + countDownLatch.getCount());
            countDownLatch.countDown();
        }
    }
}
