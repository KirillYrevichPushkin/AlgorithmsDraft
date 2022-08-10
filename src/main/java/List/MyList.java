package List;

public class MyList {

    Link first;



    public boolean isEmpty(){
        return first==null;
    }

    public void add(Link link){
            link.setNext(first);
            first = link;
    }

    public Link remove (){
        Link removeLink = first;
        first = first.getNext();
        return removeLink;
    }

    public void displayList(){
        Link current = first;

        while (current!=null){
            Link temp = current;
            System.out.println(temp.getKey() + " " + temp.getValue());
            current= temp.getNext();

        }

    }

    public Link remove(int key){
        Link current = first;
        Link previous = first;
        while (current.getKey() != key){
            if(current.getNext() == null){
                return null;
            }
            previous = current;
            current = current.getNext();
        }
        previous.setNext(current.getNext());
        return current;
    }



}
