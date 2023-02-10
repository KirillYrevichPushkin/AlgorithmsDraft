package Aston.Pattern.Builder;

import java.util.List;

public class Simple {
    private int age;
    private String name;
    private List<String> friends;

    public Simple() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Simple(int age, String name, List<String> friends) {
        this.age = age;
        this.name = name;
        this.friends = friends;
    }


    @Override
    public String toString() {
        return "Simple{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}
