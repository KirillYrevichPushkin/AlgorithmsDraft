package y88.kirill.busineslogic.announcer;

import y88.kirill.annotation.InjectByType;
import y88.kirill.busineslogic.recomendator.Recommendator;

public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String msg) {
        System.out.println(msg);
        recommendator.reccomend();
    }
}
