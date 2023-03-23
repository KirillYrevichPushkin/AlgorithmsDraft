package Aston.test;

public class MainTestRunnable4 extends Thread{
    final StringBuffer sb1 = new StringBuffer();
    final StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {

        final MainTestRunnable4 h = new MainTestRunnable4();

        new Thread(){
            public void run(){
                synchronized (this){
                  h.sb1.append("Java");
                  h.sb2.append("Thread");
                    System.out.println(h.sb1);
                    System.out.println(h.sb2);
                }

            }
        }.start();

        new Thread(){
            public void run(){
                synchronized (this){
                    h.sb1.append("Multithreading");
                    h.sb2.append("Example");
                    System.out.println(h.sb1);
                    System.out.println(h.sb2);
                }

            }
        }.start();

    }
}
