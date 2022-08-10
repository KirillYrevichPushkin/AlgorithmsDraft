package Stepik;

public class Main1 {

    public static void main(String[] args) {
    Apple apple = new Apple() {
        @Override
        public String toString() {
            return "apple";
        }
    };



    }



    void checkFruitCount(Object[] objects) {
        // enter your code

        int b  = 0;
        int a = 0;

        for (int i = 0; i < objects.length; i++) {
            if((objects[i].toString()).equals("banana")) b++;
            else if((objects[i].toString()).equals("apple")) a++;
        }

        System.out.println("banana=" + b + ", apple=" + a);

    }

    interface Apple {

    }

    interface Banana {

    }
}
