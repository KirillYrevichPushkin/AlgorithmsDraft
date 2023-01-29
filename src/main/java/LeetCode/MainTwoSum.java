package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



/**
* Учитывая массив целых чисел nums и целочисленное целевое значение, верните индексы двух чисел таким образом, чтобы они складывались в target.

Вы можете предположить, что каждый входной сигнал будет иметь ровно одно решение, и вы не можете использовать один и тот же элемент дважды.

Вы можете вернуть ответ в любом порядке.
*
* */
public class MainTwoSum {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*10);
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("---");
        int[] index = twoSum2(arr,15);
        System.out.println(Arrays.toString(index));
        System.out.println("+++++++++++");
        System.out.println(" index1 = " + arr[index[0]] + " index2 = " + arr[index[1]]);

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //index1 = nums[i];
//            if(nums[i] > target || nums[i] < -target) continue;
            for (int j = i+1; j < nums.length; j++) {
                if((nums[i] + nums[j]) == target){
                    return new int[]{i,j};
                }
            }

        }
        return new int[]{-1,-1};
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> mapNums = new HashMap<>(100);

        for (int i = 0; i < nums.length; i++) {
            if(mapNums.containsKey(target-nums[i])){
                return new int[]{mapNums.get(target-nums[i]), i};
            }
            mapNums.put(nums[i], i);
        }

        return new int[]{};
    }

}
