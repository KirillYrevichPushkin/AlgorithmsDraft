package Algorithm.RecursionSort;

import java.util.Arrays;

public class MySimpleMergeSort {

   private int[] srcArray;
   private int nElems;
   private int []sortArray;


    public MySimpleMergeSort(int[] srcArray) {
        this.srcArray = Arrays.copyOf(srcArray, srcArray.length);
        this.nElems = 0;
        this.sortArray = new int[srcArray.length];
    }


    public void mergeSort(int lowNum, int hiNum){
        int[] workArray = new int[srcArray.length];
        recursionMergeSort(workArray, lowNum, hiNum);

        for (int i = 0; i < workArray.length; i++) {
            sortArray[i] = workArray[i];
        }
    }

    private void recursionMergeSort(int[] workArray , int lowNum, int hiNum){
        if(lowNum==hiNum){
            return;
        }else {
            int mid = (lowNum + hiNum)/2;
            recursionMergeSort(workArray, lowNum, mid);
            recursionMergeSort(workArray, mid + 1, hiNum);
            merge(workArray, lowNum, mid+1, hiNum);
        }
    }

    private void merge(int [] workArray, int lowNum, int middle, int hiNum){
        int j = 0;
        int min1 = lowNum;
        int max1 = middle-1;
        int min2 = middle;
        int max2 = hiNum;
        int indexArr = lowNum;
        int n = hiNum - lowNum +1;
        int minNewArray = lowNum;

        while(min1<=max1 && min2<= max2){
            if(srcArray[min1]<= srcArray[min2]) workArray[j++] = srcArray[min1++];
            else workArray[j++] = srcArray[min2++];
        }

        while (min1<=max1){
            workArray[j++] = srcArray[min1++];
        }
        while (min2<=max2){
            workArray[j++] = srcArray[min2++];
        }

        for (int i = 0; i < n; i++) {
            srcArray[minNewArray + i] = workArray[i];
        }


    }

    public void displaySortedArray(){
        Arrays.stream(sortArray).forEach( a -> {
            System.out.print(a + " ");
        });
    }

    public int[] getSortedArray(){
        return sortArray;
    }





}
