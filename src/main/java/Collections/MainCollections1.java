package Collections;

import org.apache.logging.log4j.spi.CopyOnWrite;

import java.util.*;
import java.util.concurrent.*;

public class MainCollections1 {

    public static void main(String[] args) {

        List names = new ArrayList<>();
        names.add("Rams");
        names.add("Posa");
        names.add("Chinni");


        Spliterator namesSpliterator = names.spliterator();

        // Traversing elements
        //namesSpliterator.forEachRemaining(System.out::println);
        namesSpliterator.trySplit();

        List<String> list = new ArrayList<>() ;
        list.add ( "БМВ" ) ;
        list.add ( "Мерседес" ) ;
        list.add ( "Ауди" ) ;
        list.add ( "Феррари" ) ;
        list.add( "Ламборгини" ) ;

        String [] ar = new String[6];
        list.toArray(ar);

        for (String s: ar  ) {
            System.out.println(s);
        }


       // Set s = Set.of()
        SortedSet s;
        Set temp = Set.of(5,9,2,7,4);
        NavigableSet ns = new TreeSet(temp);

        System.out.println(ns.ceiling(10));

        Queue e = new PriorityQueue();
        //Algorithm.Stack
        Deque<Integer> deque = new LinkedBlockingDeque<>(30);

        deque.add(1);
        deque.add(3);
        deque.add(4);
        deque.add(22);
        deque.add(55);
        deque.add(34);
//        while (!deque.isEmpty()){
//            System.out.println(deque.pop());
//        }

        //ArrayList
       // ArrayDeque
      //  Deque deque2 = new LinkedList()

        deque.iterator().forEachRemaining(System.out::println);
        //ConcurrentNavigableMap r = new ConcurrentSkipListMap()



    }

}
