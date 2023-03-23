package Aston.test;

public class MainTestRunnable6 implements Runnable{
    private int x =0;
    private int y =0;

    public static void main(String[] args) {
        MainTestRunnable6 obj = new MainTestRunnable6();
        (new Thread(obj)).start();
        (new Thread(obj)).start();
        throw new MyRuntimeThrow("My runtime");
    }


    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            x++;
            y++;
            System.out.println("x = " + x + "; y = " + y);
        }
    }
}

class MyRuntimeThrow extends RuntimeException{
    MyRuntimeThrow(String msg){
        super(msg);
    }

}
