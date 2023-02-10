package Aston.Pattern.Builder;

public class MainBuilder {


    public static void main(String[] args) {
        Simple simple1;
        simple1 = new SimpleBuilder().setAge(5).setName("Tom").build();

        System.out.println(simple1);


    }


}
