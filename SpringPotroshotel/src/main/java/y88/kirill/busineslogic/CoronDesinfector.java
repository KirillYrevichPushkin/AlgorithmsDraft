package y88.kirill.busineslogic;

import y88.kirill.annotation.InjectByType;
import y88.kirill.busineslogic.announcer.Announcer;
import y88.kirill.busineslogic.policeman.Policeman;

@Deprecated
public class CoronDesinfector {

    @InjectByType
    private Announcer announcer;

    @InjectByType
    private Policeman policeman;

    public void start(Room room){

        announcer.announce("start desinfection");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("все обратно");

    }

    private void desinfect(Room room){
        System.out.println(" desinfect");
    }


}
