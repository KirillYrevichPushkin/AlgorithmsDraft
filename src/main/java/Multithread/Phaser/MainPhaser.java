package Multithread.Phaser;

import java.util.concurrent.Phaser;

public class MainPhaser {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Start");
        Phaser phaser = new Phaser();
        phaser.register();

        new Thread(new PhaserTemp(phaser, " PT1")).start();
        new Thread(new PhaserTemp(phaser, " PT2")).start();
        new Thread(new PhaserTemp(phaser, " PT3")).start();


        phaser.arriveAndAwaitAdvance();
        System.out.println("Main 0  - " + phaser.getPhase());

        phaser.arriveAndAwaitAdvance();
        System.out.println("Main 1  - "  + phaser.getPhase());

        phaser.arriveAndAwaitAdvance();
        System.out.println("Main 2  - "  + phaser.getPhase());

        phaser.arriveAndDeregister();

        System.out.println("phaser " + phaser.getRegisteredParties());
        System.out.println(Thread.currentThread().getName() + " End");

    }


}

class PhaserTemp implements Runnable {
    Phaser phaser;
    String name;

    public PhaserTemp(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + name + " Start");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + name + " phase " + phaser.getPhase() + " end");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + name + " phase " + phaser.getPhase() + " end");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
        System.out.println(Thread.currentThread().getName() + name + " phase " + phaser.getPhase() + " end");


        System.out.println(Thread.currentThread().getName() + name + " Finish");
    }
}
