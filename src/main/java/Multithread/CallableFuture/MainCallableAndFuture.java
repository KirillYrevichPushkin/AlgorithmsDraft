package Multithread.CallableFuture;

import java.util.concurrent.*;

public class MainCallableAndFuture {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Start");

        f1 = executorService.submit(new Sum(10));
        f2 = executorService.submit(new Hypot(10, 15));
        f3 = executorService.submit(new Factorial(5));

        System.out.println();
        while (!f1.isDone()){

        }
        try {
            System.out.println(f1.get(15,TimeUnit.MILLISECONDS));
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


        executorService.shutdown();


        try {
            System.out.println(new Sum(10).call());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("End");


    }
}


class Sum implements Callable<Integer>{

    int count;
    public Sum(int count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum+= i;
            Thread.sleep(200);
        }
        return sum;
    }
}

class Hypot implements Callable<Double>{
    double s1, s2;

    public Hypot(double s1, double s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt((s1*s1)+(s2*s2));
    }
}

class Factorial implements Callable<Integer>{
    int count;

    public Factorial(int count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        int f = 1;
        for (int i = 2; i <= count; i++) {
            f *=i;
        }
        return f;
    }
}

