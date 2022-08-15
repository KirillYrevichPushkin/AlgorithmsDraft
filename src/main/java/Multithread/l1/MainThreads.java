package Multithread.l1;

public class MainThreads {


    public static void main(String[] args) {
    Q q = new Q();
    new Producer(q);
    new Consumer(q);
    }

 static class Q{
    int n;
    boolean isEmpty = true;

   synchronized public int getN() {
     while (isEmpty){
         try {
             wait();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
        System.out.println("get: " + n);
     isEmpty = true;
        notify();
        return n;
    }

   synchronized public void setN(int n) {
        //this.n = n;
       while (!isEmpty){
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       this.n = n;
       isEmpty = false;
       System.out.println("set: " + n);
       notify();

    }

    boolean isEmpty(){
       return isEmpty;
    }

}

 static class Producer implements Runnable{
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Поставщик").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            q.setN(i++);}
        }
    }


 static class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Потребитель").start();
    }

    @Override
    public void run() {
        while (true){
            q.getN();
        }
    }
}








}
