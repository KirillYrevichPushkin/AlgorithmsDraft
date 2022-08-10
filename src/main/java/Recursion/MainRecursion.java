package Recursion;

public class MainRecursion {
    public static void main(String[] args) {








        hanoiTower(5,"A","B","C");

    }


    //рекурсивное решение задачи ханойской башни
    public static void hanoiTower(int n, String from, String temp, String to){
        if(n==1){
            System.out.println("Disk " + n + " from= " + from + " to= " + to);
        }else {
            hanoiTower(n-1,from, to, temp);
            System.out.println("Disk " + n + " from= " + from + " to= " + to);
            hanoiTower(n-1,temp, from, to);
        }
    }

}
