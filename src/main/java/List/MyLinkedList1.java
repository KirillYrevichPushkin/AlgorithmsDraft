package List;

import org.w3c.dom.Node;


//Обычный односвязный список
public class MyLinkedList1<E> {

   private  Node head = null;


    public void insert (E e){
        if(head ==null){
            head = new Node(null,e);
        }else {
           // Node temp = new Node()
            head = new Node(head, e);
        }
    }

    public boolean isEmpty(){
        return head ==null;
    }

    public E peek(){
        if(head ==null) return null;
        return (E) head.getE();
    }

    public E pop(){
        if(head ==null) return null;

        E e = (E)head.getE();
        head = head.next;
        return e;
    }

    public void display(){
        Node current = head;
        while(current!=null){
            System.out.println(current.getE().toString());
            current = current.next;
        }
    }

    public boolean find(E e){
        Node current = head;
        while (current!=null){
            if(current.getE().equals(e)){
                return true;
            }else {
                current = current.next;
            }
        }
        return false;
    }




    private class Node<E>{
        Node<E> next;
        E e;

        public Node(Node<E> next, E e) {
            this.next = next;
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

}
