package module10;

public class User { // оголошення класу User

    private String name; // оголошення приватного поля ім'я
    private int age; // оголошення приватного поля вік

    // створюємо геттери і сеттери

    public User(String name, int age) { // конструктор класу User з параметрами ім'я та вік
        this.name = name;
        this.age = age;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // перевизначений метод toString()
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
