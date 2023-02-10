package Multithread.start;

public class PC {

    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("Ctrl + C");

    }

}


class Q {
    int n;
    boolean isExistence = false;

    synchronized int get() throws InterruptedException {
        if (!isExistence){
            wait();}
            Thread.sleep(100);
            System.out.println("get " + n);
            isExistence = false;
            notify();
            return n;

    }

    synchronized void put (int n) throws InterruptedException {
        if (isExistence){
            wait();}
            Thread.sleep(100);
            System.out.println("put " + n);
            isExistence = true;
            this.n = n;
            notify();


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


