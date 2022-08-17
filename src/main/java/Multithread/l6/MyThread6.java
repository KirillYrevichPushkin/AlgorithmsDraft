package Multithread.l6;

import java.util.concurrent.Phaser;

public class MyThread6 implements Runnable{
    Phaser ph;
    String name;

    public MyThread6(Phaser ph, String name) {
        this.ph = ph;
        this.name = name;
        ph.register();

    }

    @Override
    public void run() {

        System.out.println("Поток №" + name+ " начал 1 фазу");
        //проводим какие нибудь операции
        ph.arriveAndAwaitAdvance(); // извещаем об окончании фазы 1

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Поток №" + name+ " начал 2 фазу");
        //проводим какие нибудь операции
        ph.arriveAndAwaitAdvance(); // извещаем об окончании фазы 2

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Поток №" + name+ " начал 3 фазу");
        //проводим какие нибудь операции
        ph.arriveAndAwaitAdvance(); // извещаем об окончании фазы 3





    }
}
