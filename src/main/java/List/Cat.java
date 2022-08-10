package List;

/**
 * My first javadoc file
 *
 *
 * */
public class Cat {

    int age;
    String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }


    /**
     * Метод возвращающий строку
     * @return String "Cat{" + "age=" + age +", name='" + name + '\'' +'}'
     * */
    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
