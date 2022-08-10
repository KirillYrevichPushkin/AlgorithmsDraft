package List;


import java.util.function.Consumer;

//Обычный двусвязный список с итератором
public class MyLinkedList2<E>  {
    private Node head = null;
    private Node tail = null;

    public Node<E>peek(){
        return head;
    }

    public Node<E>peekTail(){
        return tail;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void insert(E e){
        if(head==null){
            head = new Node(null,null,e);
            tail = head;
        }else {
            Node newNode = new Node(head,null,e);
            head.previous = newNode;
            head = newNode;
        }
    }

    public void insertTail(E e){
        if(tail==null){
            tail = new Node(null,null,e);
            head = tail;
        }else {
            Node newNode = new Node(null,tail,e);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E pop (){
        Node temp = null;
        if(head==null) return null;
        E e = (E)head.getE();
        if(head.next!=null) {
            temp = head.next;
            temp.previous = null;}
        head = temp;
        return e;
    }

    public E popTail (){
        Node temp = null;
        if(tail==null) return null;
        E e = (E)tail.getE();
        if(tail.previous!=null) {
            temp = tail.previous;
            temp.next = null;}
        tail = temp;
        return e;
    }




    public void display(){
        Node current = head;
        while(current!=null){
            System.out.println(current.getE().toString());
            current = current.next;
        }
    }






    protected class Node<E>{
        Node<E> next;
        Node<E> previous;
        E e;

        public Node(Node<E> next,Node<E> previous , E e) {
            this.next = next;
            this.previous = previous;
            this.e = e;
        }

        public Node() {

        }

        public E getE(){
            return e;
        }

        public void setE(E e){
            this.e = e;
        }
    }

    public MyIterator getIterator(MyLinkedList2<E> linkedList2){
        return new MyIterator(linkedList2);
    }


    private class MyIterator implements MyIteratorInterface<E>{
        Node<E> current;
        Node<E> next;
        Node<E> previous;
        MyLinkedList2<E> linkedList2;

        private void start(){
            if(linkedList2.head.next!=null){
                next = linkedList2.head.next;
            }


        }

        public MyIterator(MyLinkedList2<E> linkedList2) {

            this.linkedList2 = linkedList2;
            this.current = linkedList2.head;
           start();
        }

        @Override
        public void remove() {
          //  java.util.Iterator.super.remove();
           if(previous!=null) previous.next = next;
           if(next!=null) next.previous = previous;
        }

        @Override
        public void forEachRemaining(Consumer action) {
           // java.util.Iterator.super.forEachRemaining(action);
        }

        @Override
        public boolean hasNext() {
            return next!=null;
        }

        @Override
        public E next() {
            previous = current;
            current = next;
            next = next.next;
            return previous.getE();
        }


        public E nextE() {
            previous = current;
            current = next;
            next = next.next;
            return previous.getE();
        }

        @Override
        public void insertBefore (E e){
            if(previous==null){
                linkedList2.insert(e);
                previous = linkedList2.head;
                current = linkedList2.head.next;
                next = current.next;
            }else {
                Node<E> node = new Node(current,previous,e);
                previous.next = node;
                next.previous = node;
            }
        }
    }


}
