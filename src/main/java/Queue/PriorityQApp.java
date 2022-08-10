package Queue;




/*
* В рассмотренной реализации приоритетной очереди вставка выполняется за время
O(N), а извлечение — за время O(1). В главе 12 будет показано, как улучшить время
вставки за счет реализации на базе кучи.
*
* */
public class PriorityQApp {
    private int nItems;
    private int maxSize;
    private long[] queArray;

    public PriorityQApp(int s){
        maxSize = s;
        queArray = new long[maxSize];
    }

    public long remove (){
        return queArray[--nItems];
    }

    public void insert (long item){

        int j;

        if(nItems==0)                           // Если очередь пуста,
            queArray[nItems++] = item;          // вставляем в ячейку 0
        else                                    // Если очередь содержит элементы
        {
            for(j=nItems-1; j>=0; j--)          // Перебор в обратном направлении
            {
                if( item > queArray[j] )        // Если новый элемент больше,
                    queArray[j+1] = queArray[j]; // сдвинуть вверх
                else                            // Если меньше,
                    break;                      // сдвиг прекращается
            }
            queArray[j+1] = item;                  // Вставка элемента
            nItems++;
        }

    }


    //-------------------------------------------------------------
    public long peekMin() // Чтение минимального элемента
    { return queArray[nItems-1]; }
    //-------------------------------------------------------------
    public boolean isEmpty() // true, если очередь пуста
    { return (nItems==0); }
    //-------------------------------------------------------------
    public boolean isFull() // true, если очередь заполнена
    { return (nItems == maxSize); }

}
