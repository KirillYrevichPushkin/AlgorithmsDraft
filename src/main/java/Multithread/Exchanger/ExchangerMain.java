package Multithread.Exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerMain {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        new Thread( new MakeObj(exchanger)).start();
        new Thread(new UseObj(exchanger)).start();


    }


}

class MakeObj implements Runnable{
    Exchanger<String> ex;
    String str;

    public MakeObj(Exchanger<String> ex) {
        this.ex = ex;
        this.str = new String();
    }

    @Override
    public void run() {
        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += (char)ch++;
            }

            try {
                //обмен данными
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}


class UseObj implements Runnable{

    Exchanger<String> ex;
    String str;

    public UseObj(Exchanger<String> ex) {
        this.ex = ex;
        this.str = new String();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Получено " + str);
            str = "";
        }
    }
}
