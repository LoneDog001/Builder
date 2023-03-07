import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);
        return child;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        if (this.age <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        if (this.address == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        if (this.age < 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.age);
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age = this.age + 1;
    }

    @Override
    public String toString() {
        return " " +
                "с именем = " + name +
                ", фамилией = " + surname +
                ", возрастом = " + age +
                ", из города = " + address +
                ' ';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}

