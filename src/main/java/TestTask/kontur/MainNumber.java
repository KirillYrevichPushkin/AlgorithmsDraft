package TestTask.kontur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainNumber {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt( br.readLine());
            int[] numberArray = new int[number];
            for (int i = 0; i < number; i++) {
                numberArray[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(numberArray);
            int endNumber = getNumber(numberArray);
            System.out.println(endNumber);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int getNumber (int[] array){
        int number = 0;
        for (int i = 0; i < array.length/2; i++) {
            if( Math.abs( array[i]) != array[array.length -1-i]){
                if( Math.abs(array[i]) > array[array.length -1-i]){
                    number = Math.abs(array[i]);
                }else {
                    number = - array[array.length -1-i];
                }
                break;
            }
        }
        return number;
    }
}
