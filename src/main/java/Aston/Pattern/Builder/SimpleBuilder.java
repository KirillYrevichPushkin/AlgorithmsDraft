package Aston.Pattern.Builder;

import java.util.List;

public class SimpleBuilder {
    private int age;
    private String name;
    private List<String> friends;
    private Simple simple;

    public SimpleBuilder() {
        this.simple = new Simple();
    }

    public SimpleBuilder setAge(int age) {
        this.simple.setAge(age);
        return this;
    }

    public SimpleBuilder setName(String name) {
        this.simple.setName(name);
        return this;
    }

    public SimpleBuilder setFriends(List<String> friends) {
        this.simple.setFriends(friends);
        return this;
    }

    public Simple build(){
        return this.simple;
    }

}
