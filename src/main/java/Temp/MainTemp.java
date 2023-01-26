package Temp;

import yandex.back.A;

import java.sql.SQLOutput;
import java.util.*;

public class MainTemp {

    public static void main(String[] args) {



        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Set<Person> people = new TreeSet<>(comparator);
        people.add(new Person(25,"Tom"));
        people.add(new Person(15,"Tom1"));
        people.add(new Person(85,"Tom2"));
        people.add(new Person(22,"Tom3"));
        people.add(new Person(23,"Tom4"));
        people.add(new Person(28,"Tom5"));
        people.add(new Person(29,"Tom6"));
        people.add(new Person(27,"Tom7"));
        people.add(new Person(24,"Tom8"));
        people.add(new Person(255,"Tom9"));
        people.add(new Person(222,"Tom10"));
        people.add(new Person(27,"Tom11"));
        people.add(new Person(15,"Tom1"));

        System.out.println(people.toString());
        List<Person> personList = new ArrayList<>();




        Iterator<Person> personIterator = people.iterator();
        while (personIterator.hasNext()){
            if(personIterator.next().getAge() < 28){
                personIterator.remove();
            }
        }
        System.out.println();
        System.out.println(personIterator.toString());
        System.out.println();
        System.out.println(people.toString());

        System.out.println("------------");
        System.out.println(new Person(15, "t").hashCode());
        System.out.println(new Person(15, "tt").hashCode());
        System.out.println(new Person(15, "tt").hashCode());


        Map<String, Person> personMap = new HashMap<>();




    }



}
