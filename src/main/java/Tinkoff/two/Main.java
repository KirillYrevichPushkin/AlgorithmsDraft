package Tinkoff.two;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cake = sc.nextInt();
        double sic = 0;
        int sicInt = 0;

            sic = log2(cake);
            sicInt = (int)sic;

            if(cake ==1){
                System.out.println(0);
            }else if(sic%sicInt==0){
                System.out.println(sicInt);
            }else {
                sicInt = sicInt +1;
                System.out.println(sicInt);
            }
    }


    private static double log2(int x){
        return Math.log(x)/Math.log(2);
    }

}
