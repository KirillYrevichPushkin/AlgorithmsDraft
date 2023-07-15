package y88.kirill.busineslogic.policeman;

public class AngryPoliceman implements Policeman {

    public void init(){
        System.out.println("hi");
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("kil kil kill");
    }
}
