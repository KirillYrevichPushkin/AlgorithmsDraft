package HTTP;

public class Temp2 extends Temp{
    String name;

    public Temp2(int one, String name) {
        super(one);
        this.name = name;
    }

    public Temp2(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Temp2{" +
                "one=" + one +
                ", name='" + name + '\'' +
                '}';
    }
}
