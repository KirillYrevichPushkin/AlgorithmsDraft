package Multithread.start;

public class Synch1 {
    public static void main(String[] args) {

        Callme target = new Callme();
        Caller caller1 = new Caller("hi", target);
        Caller caller2 = new Caller("you", target);
        Caller caller3 = new Caller("!", target);

        caller3.t.interrupt();


        try {
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

}

class Callme {
    void  call(String msg){
        System.out.print("[" + msg);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.err.println(" err");
        }
        System.out.println("]");
    }
}

class Caller implements  Runnable{

    String msg;
    Callme target;
    Thread t;

    public Caller(String msg, Callme target) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        synchronized (Caller.class) {
            target.call(msg);
        }
    }
}
