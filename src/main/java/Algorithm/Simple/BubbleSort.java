package Algorithm.Simple;

public class BubbleSort {

    public static void main(String[] args) {

        int [] inputArray = new int[15];
        int [] outputArray;

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = (int) (Math.random()*100);
            System.out.println(inputArray[i]);
        }

        System.out.println("+++++++");

        outputArray = arrBubbleSorted2(inputArray);
        for (int i = 0; i < outputArray.length; i++) {
            System.out.println(outputArray[i]);
        }


    }


  //Алгоритм пузырьковой сортировки работает так: вы подходите к левому краю
  //шеренги (позиция 0) и сравниваете двух игроков в позициях 0 и 1. Если левый
  //игрок (позиция 0) выше, вы меняете их местами. Если выше правый игрок, они
  //остаются на своих местах. Затем вы переходите на одну позицию вправо и сравниваете игроков в позициях 1 и 2. И снова, если левый игрок выше, вы меняете их
  //местами.
  //Перестановки продолжаются до тех пор, пока не будет достигнут правый край
 //   шеренги.
    //количество перестановок O(N2)
    //количество сравнений O(N2)
    public static int [] arrBubbleSorted (int [] arr){
        int temp = 0;
        int k = 0;

        for (int i = 0; i < arr.length ; i++ , k++) {
            for (int j = 0; j < arr.length-k-1 ; j++ ) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    //такой пузырек лучше (нет необходимости возвращать массив, это же бред)
    public static int[] arrBubbleSorted2 (int[] arr){
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(j, j+1, arr);
                }
            }
        }
        return arr;
    }

    public static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }




}
