package Multithread.l6;

import java.util.concurrent.Phaser;

public class MyPhaser {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currentPhase;
        System.out.println("Start thread");

        new Thread(new MyThread6(phaser, "A")).start();
        new Thread(new MyThread6(phaser, "B")).start();
        new Thread(new MyThread6(phaser, "C")).start();


        //ожидание завершения потоками 1 фазы
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currentPhase + " завершена");

        //ожидание завершения потоками 2 фазы
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currentPhase + " завершена");

        //ожидание завершения потоками 3 фазы
        currentPhase = phaser.getPhase();
       phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currentPhase + " завершена");

        //снять основной поток исполнения с регистрации
        phaser.arriveAndDeregister();

        if(phaser.isTerminated()){

            System.out.println("Синхронизатор фаз завершен");
        }


    }

}
