package Algorithm.Stack;


public class SimpleStack {
    int maxSize;
    int top;
    int[] arr;

    public SimpleStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

    public void push (int element){
        arr[++top] = element;
    }

    public int pop (){
        return arr[top--];
    }

    public int peek (){
        return arr[top];
    }


}
