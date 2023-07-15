package y88.kirill.busineslogic.policeman;

import y88.kirill.annotation.InjectByType;
import y88.kirill.busineslogic.recomendator.Recommendator;

import javax.annotation.PostConstruct;

public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;


    @PostConstruct
    public void init(){
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("GOGOGOG");
    }
}
