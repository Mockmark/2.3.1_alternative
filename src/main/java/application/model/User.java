package application.model;

public class User {
    long id;
    String name;
    String password;
    int age;

    public User() {
    }

    public User(long id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
