package Multithread.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class MainLock {

    public static void main(String[] args) {
    ReentrantLock reentrantLock = new ReentrantLock();
        System.out.println( "Start" + Thread.currentThread().getName() + " count " + Shared.count );
        new Thread(new LockThreadInc(reentrantLock, "inc")).start();
        new Thread(new LockThreadDeck(reentrantLock,"deck")).start();


        System.out.println("End" + Thread.currentThread().getName() + " count " + Shared.count );

    }



}

class Shared{
    public static int count = 0;
}

class LockThreadInc implements Runnable{
    ReentrantLock reentrantLock;
    String name;

    public LockThreadInc(ReentrantLock reentrantLock, String name) {
        this.reentrantLock = reentrantLock;
        this.name = name;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        for (int i = 0; i < 10; i++) {

                Shared.count++;
                System.out.println(Thread.currentThread().getName() + " count " + Shared.count);


                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        reentrantLock.unlock();
        }


}

class LockThreadDeck implements Runnable{
    ReentrantLock reentrantLock;
    String name;

    public LockThreadDeck(ReentrantLock reentrantLock, String name) {
        this.reentrantLock = reentrantLock;
        this.name = name;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        for (int i = 0; i < 10; i++) {


                Shared.count--;
                System.out.println(Thread.currentThread().getName() + " count " + Shared.count);


                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        reentrantLock.unlock();
        }

    }


