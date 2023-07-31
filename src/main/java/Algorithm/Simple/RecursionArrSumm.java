package Algorithm.Simple;

import java.util.Arrays;

public class RecursionArrSumm {


//рекурсивный метод для определения суммы элементов массива
    public static void main(String[] args) {

        System.out.println( arrSum(new int[]{1, 7, 9, 2, 5, 2}));
    }

    public static int arrSum (int [ ] arr){
        if(arr.length == 0){
            return 0;
        }else if(arr.length == 1){
            return arr[0];
        }else {
           return arr[0] +  arrSum(Arrays.copyOfRange(arr,1, arr.length));
        }
    }


}
