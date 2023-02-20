package StreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainSimpleStream {
    static int k = 0;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(10, "Tom"));
        people.add(new Person(15, "Tim"));
        people.add(new Person(12, "John"));
        people.add(new Person(14, "Aaron"));
        people.add(new Person(17, "Sam"));
        people.add(new Person(15, "Thorn"));
        people.add(new Person(11, "Ben"));
        people.add(new Person(11, "Jam"));
        people.add(new Person(13, "Anna"));
        people.add(new Person(19, "Zokhan"));
        people.add(new Person(10, "Tom"));
        people.add(new Person(13, "Krill"));
        people.add(new Person(12, "Shark"));
        people.add(new Person(11, "Samuel"));
        people.add(new Person(19, "Jackson"));
        people.add(new Person(17, "Jim"));
        people.add(new Person(11, "Beam"));
        people.add(new Person(10, "Morgan"));
        people.add(new Person(15, "Samantha"));
        people.add(new Person(18, "Saint"));
        people.add(new Person(19, "Peter"));
        people.add(new Person(11, "Leah"));
        people.add(new Person(12, "Fay"));
        people.add(new Person(17, "Barth"));
        people.add(new Person(19, "Liza"));



        Map<Integer, List<Person>> peopleMap = new HashMap<>();
        for (int i = 10; i < 20; i++) {
            k = i;
            peopleMap.put(i,people.stream().filter(p -> p.getAge()==k).collect(Collectors.toList()));
        }

        Map<Integer, List<Person>> peopleMap2 = people.stream().collect(Collectors.groupingBy(p -> p.getAge()));
        Map<Integer, Person> peopleMap3 = people.stream().
                collect(Collectors.toMap( p -> p.getAge(),
                        p -> {return p;}, (a, b)->{ return b;}));



        for ( Map.Entry<Integer, List<Person>> es : peopleMap2.entrySet()) {
            System.out.println("+++++");
            for (Person p: es.getValue()     ) {
                System.out.println(p.toString());
            }
        }
        System.out.println("hashmap3");
        for ( Map.Entry<Integer, Person> es : peopleMap3.entrySet()) {
            System.out.println("+++++");
                System.out.println(es.getValue());

        }


        Comparator<Person> comparatorAge = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Person)o1).getAge()-((Person)o2).getAge();
            }
        };

        System.out.println(" \nsorted age\n");

        List<Person> peopleSortedAge = people.stream().sorted(comparatorAge).collect(Collectors.toList());
        peopleSortedAge.forEach(p -> {
            System.out.println(p.toString());
        });

        Comparator<Person> comparatorName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Person)o1).getName().compareTo(((Person)o2).getName());
            }
        };

        System.out.println(" \nsorted name\n");

        List<Person> peopleSortedName = people.stream().sorted(comparatorName).collect(Collectors.toList());
        peopleSortedName.forEach(System.out::println);

        System.out.println("getCount");
        System.out.println( people.stream().filter(p->p.getAge()>15&&p.age<18).count());

        System.out.println("max");
        System.out.println(people.stream().max(comparatorAge).get());

        System.out.println("habr");

        Stream.of("d1", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });


        //пример использования фильтра, который перебрал всю коллекцию
        System.out.println("использование фильтра");
        peopleSortedAge.stream().filter(p ->{
            System.out.println("filter " + p.toString());
            return p.getAge()<15;
        }).forEach(p->{
            System.out.println("end " + p.toString());
        });

        //пример использования anyMatch перебор коллекции останавливается по достижении определенного результата
        System.out.println("anyMatch");
        peopleSortedAge.stream().map(p ->{
            System.out.println("map " + p.toString());
            return p;
        }).anyMatch(p->{
            System.out.println("anyMatch " + p.toString());
            return p.getAge()>=15;
        });





    }


}


class Person{
    int age;
    String Name;

    public Person(int age, String name) {
        this.age = age;
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }
}
