package yandex.kontest;

import java.util.*;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список
//    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
//        // Ваше решение
//        List<Integer> sum = new ArrayList<>();
//        Collections.sort(arr);
//        int a, z;
//        int i = 0, j = arr.size()-1;
//        while (i!=j){
//            a = arr.get(i);
//            z = arr.get(j);
//            if ((a + z) ==targetSum ){
//                sum.add(a);
//                sum.add(z);
//                return sum;
//            }else if((a + z) >targetSum){
//                j--;
//            }else {
//                i++;
//            }
//        }
//        return sum;
//    }

    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        // Ваше решение
        List<Integer> sum = new ArrayList<>();
        Set<Integer> set = Set.copyOf(arr);
        int a;
        for (int i = 0; i < arr.size(); i++) {
            a = arr.get(i);
            if(set.contains(targetSum-a)){
                sum.add(a);
                sum.add(targetSum-a);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return  Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

}
