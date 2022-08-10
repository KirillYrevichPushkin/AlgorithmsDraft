package ThermalPower;

import com.hummeling.if97.IF97;

public class MyTPClass {
    public static void main(String[] args) {
        IF97 if97 = new IF97(IF97.UnitSystem.ENGINEERING);
        System.out.println(if97.specificVolumePT(3,300));
    }


}
