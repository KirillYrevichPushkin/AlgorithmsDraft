package Aston.test;

import java.util.ArrayList;

public class MainTestRunnable3 implements Runnable {

    public static void main(String[] args) {
        new MainTestRunnable3().run();

        ArrayList<? super Number> numbers = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        ArrayList list = new ArrayList();
        numbers = objects;
    }

    @Override
    public void run() {
        System.out.println("I be");
    }
}
