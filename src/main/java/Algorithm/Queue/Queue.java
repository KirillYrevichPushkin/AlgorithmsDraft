package Algorithm.Queue;

public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems; //количество элементов

    public Queue (int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert (long j){
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public long remove (){
        long temp = queArray[front++];
        if(front == maxSize){
            front=0;
        }
        nItems--;
        return  temp;
    }

    //--------------------------------------------------------------
    public long peekFront() // Чтение элемента в начале очереди
    {
        return queArray[front];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true, если очередь пуста
    {
        return (nItems==0);
    }
    //--------------------------------------------------------------
    public boolean isFull() // true, если очередь заполнена

    {
        return (nItems==maxSize);
    }
    //--------------------------------------------------------------
    public int size() // Количество элементов в очереди
    {
        return nItems;
    }


}
