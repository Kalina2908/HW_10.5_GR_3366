package Model;

public class User {
    private String firstName; // имя
    private String secondName; // фамилия
    private int age; // возраст

    /** конструктор */
    public User(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    /** метод получения имени */
    public String getFirstName() {
        return firstName;
    }

    /** метод присовения имени */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** метод получения фамилии */
    public String getSecondName() {
        return secondName;
    }

    /** метод пприсвоения фамилии */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /** метод получения возраста */
    public int getAge() {
        return age;
    }

    /** метод присвоения возраста */
    public void setAge(int age) {
        this.age = age;
    }

    /** перераспределение вывода */
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
