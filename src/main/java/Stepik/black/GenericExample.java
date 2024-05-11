package Stepik.black;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class GenericExample {

  public static void main(String[] args) {

  List<? super Number> l = new ArrayList<>();
  l.add(7);
  l.add(7.1);
  l.add(7.5f);
  l.add(7);




//    List<? extends Number> l2 = new ArrayList<>();
//    l2.add(7);
//    l2.add(7.1);
//    l2.add(7.5f);
//    l2.add(7);




    printMy(l);


  }

  static void printMy(List<?> list){
    System.out.println("Hi " + list);
  }

}
