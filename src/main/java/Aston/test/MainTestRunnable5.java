package Aston.test;

public class MainTestRunnable5 extends  Thread{

    MainTestRunnable5(){
        System.out.print(" MyThread");
    }

    public void run(){
        System.out.print(" bar");
    }

    public void run(String s){
        System.out.println(" baz");
    }


}

class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new MainTestRunnable5(){

            public void run() {
                System.out.println(" foo");
            }
        };
        t.start();

    }
}
