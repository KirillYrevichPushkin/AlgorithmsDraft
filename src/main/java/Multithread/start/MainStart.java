package Multithread.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yandex.kontest.E;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;


public class MainStart {

    private static final Logger logger = LoggerFactory.getLogger(MainStart.class);


    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.isAlive());
        System.out.println(t.getName());
        t.setName("T1");
        System.err.println(t.getName());

        logger.info("logger info");

        SimpleThread st = new SimpleThread("simple");
        logger.info(st.t.getState().toString());







        //из теста Aston
/*        System.out.println("1");
        synchronized (args){
            System.out.println("2");
            try {
                args.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("3");*/




    }

}

class SimpleThread implements Runnable{
    Thread t;
    String msg;

    public SimpleThread(String msg) {
        this.msg = msg;
        this.t = new Thread(this, msg);
        this.t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println("thread = " + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
