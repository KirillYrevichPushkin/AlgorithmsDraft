package logging;

import com.hummeling.if97.IF97;

public class MyMainLogging {

    private static OrderLogic logic;

    public static void main(String[] args) {
        logic = new OrderLogic();
        logic.doOrder();

        IF97 if97 = new IF97(IF97.UnitSystem.ENGINEERING);
        System.out.println(if97.specificVolumePH( 5, 1500));

    }

}
