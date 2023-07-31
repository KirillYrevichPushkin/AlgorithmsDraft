package Algorithm.Queue;




//моя версия
public class PriorityQueue2 {
    int front = -1;
    int[]arr;
    int size;

    public PriorityQueue2(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public int remove(){
        return arr[front--];
    }

    public int peek(){
        return arr[front];
    }

    public boolean isEmpty(){
        return front ==-1;
    }

    public boolean ifFull(){
        return front==size;
    }

    public void add(int item){
        int temp;
        front++;

        if(front==0){
            arr[0] = item;
        }else {
            for (int i = 0; i <= front; i++) {
                if (item < arr[i]) {  //найдена точка вставки, после чего реализуется просто сдвиг
                    for( int j = i ; j<= front; j++, i++) {
                        temp = arr[j];
                        arr[j] = item;
                        item = temp;
                    }
                } else {
                arr[front] = item;
                }
            }

            }
    }
}



