package Aston.test;

public class MainTestRunnable implements Runnable {
    String x, y;


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this){
                x = "Hello";
                y = "Java";
                System.out.print(x + " " + y + " ");
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        MainTestRunnable run = new MainTestRunnable();
        Thread obj1 = new Thread(run);
        Thread obj2 = new Thread(run);
        obj1.start();
        obj2.start();


    }


}
