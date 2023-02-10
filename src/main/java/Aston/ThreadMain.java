package Aston;

import java.util.concurrent.*;

public class ThreadMain {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Integer a = 15;
        Integer b = 55;
        Callable<Integer> callable = () -> {
            Thread.sleep(3000);
            return a+b;};
       // System.out.println(callable.call());

        Future<Integer> future = executorService.submit(callable);

        System.out.println(future.get());

        executorService.shutdown();




    }
}
