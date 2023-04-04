package TestTask.kontur;

import java.io.*;
import java.util.*;

public class MainIndianPale {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String number = br.readLine();

        double max = getNumber(number, true);
        double min = getNumber(number, false);
        String out = String.format("%.0f" ,max - min);
        System.out.println(out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getNumber(String number, boolean max){
        List<Character> list = new ArrayList<>();
        for (char c : number.toCharArray()) {
            if(c == '.' || c == ',' ){
                break;
            }
            list.add(c);
        }

        if(max) {
            list.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o2 - o1;
                }
            });
        }else {
            list.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1 - o2;
                }
            });
        }

        StringBuilder en = new StringBuilder();
        for (Character c:list ) {
            en.append(c);
        }
       double exitNumber = Double.parseDouble(en.toString());
       return exitNumber;
    }

}
