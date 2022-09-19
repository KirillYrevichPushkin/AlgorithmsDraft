package CMD;

public class MainOS {

    public static void main(String[] args) {

//        System.getProperties().list(System.out);
       String msg =  System.getProperty("os.name");
       if (msg.contains("Windows")){
           System.out.println("винда");
       }else {
           System.out.println("не винда какая то");
       }
        System.out.println(msg);


    }

}
