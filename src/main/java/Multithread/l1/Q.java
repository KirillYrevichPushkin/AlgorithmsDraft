package Multithread.l1;

class Q{
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

