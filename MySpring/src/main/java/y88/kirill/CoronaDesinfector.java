package y88.kirill;

public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;

    @InjectByType
    private Policeman policeman;


    public void start(Room room){

        announcer.announce("Начинаем дезинфекцию, всё вон!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Рискните зайти обратно");
    }

    private void desinfect(Room room){
        System.out.println("Зачитывается молитва: корона изыди");

    }
}
