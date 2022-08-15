package Multithread.l1;

public class MainShildt1 {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);


    }

}
