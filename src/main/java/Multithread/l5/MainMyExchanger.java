package Multithread.l5;

import java.util.concurrent.Exchanger;

public class MainMyExchanger {

    public static void main(String[] args) {
        Exchanger<String> myExchanger = new Exchanger<>();
        new Thread(new UseDataThread(myExchanger)).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new CreateDataThread(myExchanger)).start();



    }

}
