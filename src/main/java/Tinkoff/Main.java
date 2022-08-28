package Tinkoff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int C = Integer.parseInt(arr[2]);
        int D = Integer.parseInt(arr[3]);

        int sum;
        if(D <= B){
            sum = A;
        }else {
            sum = A + (D-B)*C;
        }
        System.out.println(sum);
    }
}
