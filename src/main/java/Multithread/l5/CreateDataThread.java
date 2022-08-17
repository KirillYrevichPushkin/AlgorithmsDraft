package Multithread.l5;

import java.util.concurrent.Exchanger;

public class CreateDataThread implements Runnable{
    Exchanger<String> exchanger;
    String msg = "";

    public CreateDataThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <5 ; j++) {
                msg +=  ch++;
            }
            try {
                msg = exchanger.exchange(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
