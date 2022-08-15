package Multithread.l2;

import java.util.concurrent.Semaphore;

class Q{
    int n;
   // boolean isEmpty = true;

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    public void getN() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get: " + n);
        semProd.release();

    }

     public void setN(int n) {

         try {
             semProd.acquire();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         this.n = n;
        System.out.println("set: " + n);
        semCon.release();

    }


}

