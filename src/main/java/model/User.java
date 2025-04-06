package model;

public class User {
    int id;
    String name;
    String password;
    int age;

    public User() {
    }

    public User(int id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
