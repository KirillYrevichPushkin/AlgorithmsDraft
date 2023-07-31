package Algorithm.Queue;

public class MainQueue {

    public static void main(String[] args) {


        PriorityQApp priorityQApp = new PriorityQApp(10);

        priorityQApp.insert(15);
        priorityQApp.insert(2);
        priorityQApp.insert(7);
        priorityQApp.insert(21);
        priorityQApp.insert(4);

        System.out.println(priorityQApp.remove());
        System.out.println(priorityQApp.remove());
        System.out.println(priorityQApp.remove());
        System.out.println(priorityQApp.remove());
        System.out.println(priorityQApp.remove());
     //   System.out.println(priorityQApp.remove());

        PriorityQueue2 priorityQueue2 = new PriorityQueue2(6);
        priorityQueue2.add(8);
        priorityQueue2.add(1);
        priorityQueue2.add(19);
        priorityQueue2.add(4);
        priorityQueue2.add(9);


        System.out.println("-------");
        System.out.println(priorityQueue2.remove());
        System.out.println(priorityQueue2.remove());
        System.out.println(priorityQueue2.remove());
        System.out.println(priorityQueue2.remove());
        System.out.println(priorityQueue2.remove());
      //  System.out.println(priorityQueue2.remove());


    }

}
