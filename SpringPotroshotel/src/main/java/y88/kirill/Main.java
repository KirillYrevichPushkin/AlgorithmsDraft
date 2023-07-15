package y88.kirill;


import y88.kirill.busineslogic.CoronDesinfector;
import y88.kirill.busineslogic.Room;
import y88.kirill.busineslogic.policeman.Policeman;
import y88.kirill.busineslogic.policeman.PolicemanImpl;
import y88.kirill.core.Application;
import y88.kirill.core.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = Application.run("y88.kirill", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronDesinfector coronDesinfector = context.getObject(CoronDesinfector.class);

        coronDesinfector.start(new Room());






        try {
            Room room = (Room) Class.forName("y88.kirill.busineslogic.Room").getDeclaredConstructor().newInstance();
            System.out.println(room.toString());
            System.out.println(room.getClass().getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
