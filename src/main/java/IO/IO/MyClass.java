package IO.IO;

import java.io.Serializable;

public class MyClass implements Serializable {
     String s;
     int i;

    public MyClass(String s, int i) {
        this.s = s;
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public int getI() {
        return i;
    }
}
