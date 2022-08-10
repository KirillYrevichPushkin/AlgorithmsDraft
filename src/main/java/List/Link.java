package List;

public class Link {
    private int key;
    private double value;
    private Link next;

    public Link(int msg, double value) {
        this.key = msg;
        this.value = value;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
