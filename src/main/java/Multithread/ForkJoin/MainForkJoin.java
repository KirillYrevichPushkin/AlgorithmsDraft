package Multithread.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MainForkJoin {
    public static void main(String[] args) {

        ForkJoinPool fjp = new ForkJoinPool();
       // ForkJoinPool fjp = ForkJoinPool.commonPool();

        double [] nums = new double[400000000];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        long t2 = System.currentTimeMillis()-t1;

        System.out.println("часть исходной последовательности");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        System.out.println(" time add = " + t2);

        long t1a = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.sqrt(nums[i]);
        }
        long t2a = System.currentTimeMillis()-t1;
        System.out.println("Время линейной операции = " + t2a);


        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        long t3 = System.currentTimeMillis();
        //fjp.invoke(task);
        task.invoke();
        long t4 = System.currentTimeMillis()-t3;
        System.out.println(" time update = " + t4);

        System.out.println("часть преобразованной последовательности");
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f", nums[i]);
        }
        fjp.shutdown();
        System.out.println("\n");

    }


}

class SqrtTransform extends RecursiveAction {
    final int seqThreshold = 100000;

    double[] data;

    int start, end;

    public SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if((end-start) < seqThreshold){
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        }else {
            int middle = (start+end)/2;
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }


    }
}
