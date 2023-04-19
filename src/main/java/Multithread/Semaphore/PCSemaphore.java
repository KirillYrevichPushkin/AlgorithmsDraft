package Multithread.Semaphore;

import java.util.concurrent.Semaphore;

public class PCSemaphore {

    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("Ctrl + C");
    }
}


class Q {
    int n;

    static Semaphore semProd = new Semaphore(1);
    static Semaphore semCons = new Semaphore(0);

    int get() throws InterruptedException {
        semCons.acquire();
            Thread.sleep(100);
            System.out.println("get " + n);
        semProd.release();
            return n;

    }

    void put (int n) throws InterruptedException {
        semProd.acquire();
            Thread.sleep(100);
            System.out.println("put " + n);
            this.n = n;
        semCons.release();

    }

}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true)
            try {
                q.put(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true)
            try {
                q.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}


