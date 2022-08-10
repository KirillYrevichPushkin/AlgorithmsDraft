package List;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkApp {

    public static void main(String[] args) {
        List t = new LinkedList<>();
        Iterator iterator = t.iterator();

//        MyList myList = new MyList();
//        myList.add(new Link(1, 12));
//        myList.add(new Link(2, 9));
//        myList.add(new Link(3, 124));
//        myList.add(new Link(4, 1214));
//        myList.add(new Link(5, 7542));
//
////        System.out.println(myList.remove().getMsg());
////        System.out.println(myList.remove().getMsg());
////        System.out.println(myList.remove().getMsg());
////        System.out.println(myList.remove().getMsg());
////        System.out.println(myList.remove().getMsg());
//  //      System.out.println(myList.remove().getMsg());
////        System.out.println(myList.remove().getMsg());
//
//        myList.displayList();
//        myList.remove(3);
//        System.out.println();
//        myList.displayList();

        MyLinkedList1<Cat> linkedList1 = new MyLinkedList1<Cat>();
        Cat cccat = new Cat(7,"sdfsf");
        linkedList1.insert(new Cat(1, "qwerty"));
        linkedList1.insert(new Cat(5,"zxcvb"));
        linkedList1.insert(new Cat(3, "afaaf"));

//        System.out.println(linkedList1.pop().toString());
//        System.out.println(linkedList1.pop().toString());
//        System.out.println(linkedList1.pop().toString());
        System.out.println(linkedList1.find(cccat));
        linkedList1.insert(cccat);
        linkedList1.display();
        System.out.println(linkedList1.find(cccat));


        MyLinkedList2<Cat> linkedList2 = new MyLinkedList2<Cat>();
        linkedList2.insert(new Cat(1, "qwerty"));
        linkedList2.insert(new Cat(5,"zxcvb"));
        linkedList2.insert(new Cat(3, "afaaf"));
        linkedList2.insertTail(new Cat(22, "yyfqrrafaf"));
        linkedList2.insertTail(new Cat(134, "34fgsgggf"));

        System.out.println("display");
        linkedList2.display();

//        System.out.println("pop");
//        System.out.println(linkedList2.pop().toString());
//        System.out.println(linkedList2.popTail().toString());
//        System.out.println(linkedList2.pop().toString());
//        System.out.println(linkedList2.pop().toString());
        MyIteratorInterface iteratorInterface = linkedList2.getIterator(linkedList2);
        System.out.println("iterator");
        System.out.println(iteratorInterface.nextE().toString());
        System.out.println(iteratorInterface.nextE().toString());
        System.out.println("iterator");
        iteratorInterface.insertBefore(cccat);



        System.out.println("display");
        linkedList2.display();



    }

}
