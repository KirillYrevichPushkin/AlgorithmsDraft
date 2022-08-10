package Simple;

public class RecursionTowers {

    public static void main(String[] args) {

        doTowers(3, 'A', 'B', 'C');

    }


//Все диски имеют разный диаметр, а в середине у них просверлено отверстие, что
//позволяет складывать их в стопки. Изначально все диски находятся на стержне A (по возрастанию в виде пирамиды).
//Цель головоломки — переложить все диски со стержня A на стержень C. Диски
//перекладываются по одному, причем запрещается класть диск на другой диск
//меньшего размера.

    public static void doTowers(int topN,
                                char from, char inter, char to)
    {
        if(topN==1)
            System.out.println("Disk 1 from " + from + " to "+ to);
        else
        {
            doTowers(topN-1, from, to, inter); // from-->inter
            System.out.println("Disk " + topN + " from " + from + " to "+ to);
            doTowers(topN-1, inter, from, to); // inter-->to
        }
    }

}
