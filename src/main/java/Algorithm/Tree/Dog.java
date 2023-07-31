package Algorithm.Tree;

public class Dog implements Comparable<Dog> {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Dog o) {
        return this.age < o.age ? -1 : this.age > o.age ? 1 : 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
