package Stack;


public class  StackX <T> {
    private int maxSize;
    private T [] stackArray;
    private int top;

    public StackX  (int s){
        maxSize = s;
        stackArray = (T[]) new  Object[maxSize];
        top = -1;
    }

    public void push (T j){
        stackArray[++top] = j;
    }

    public T pop (){
        return stackArray[top--];
    }

    public T peek(){
        return stackArray[top];
    }

    public boolean isEmpty() // True, если стек пуст
    {
        return (top == -1);
    }

    public boolean isFull() // True, если стек полон
    {
        return (top == maxSize-1);
    }

    public int size(){
        return top+1;
    }




}
