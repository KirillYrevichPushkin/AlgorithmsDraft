package HTTP;

public class Temp {
     int one;

    public Temp(int one) {
        this.one = one;
    }

    public Temp() {
    }

    //    static {
//        System.out.println("+++static");
//    }
    public static void badMethod(){
        throw new Error();
    }

    protected int method1(int a, int b){
        return 0;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "one=" + one +
                '}';
    }
}
