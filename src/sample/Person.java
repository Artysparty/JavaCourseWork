package sample;

public class Person {
    private int id;
    private String firstName;
    private String password;
    private String lastName;
    private String username;

    public Person(int id, String firstName, String lastName, String password, String username) {
        this.id = id;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}