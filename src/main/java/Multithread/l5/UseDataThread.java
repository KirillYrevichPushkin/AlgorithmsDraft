package Multithread.l5;

import java.util.concurrent.Exchanger;

public class UseDataThread implements Runnable{
    Exchanger<String> exchanger;
    String msg;

    public UseDataThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                msg = exchanger.exchange("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg);
        }
    }
}
