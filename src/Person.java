import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        }
        return OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (hasAddress()) {
            this.address = address;
        } else {
            System.out.println("Адрес известен");
        }
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("\n").append("Имя = ").append(name).append("\n").append("Фамилия = ").append(surname).append("\n");
        if (getAge().isPresent()) {
            info.append("Возраст = ").append(age).append("\n");
        }
        if (address != null) {
            info.append("Город = ").append(address).append("\n");
        }
        return info.toString();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname);
        result += age != 0 ? Objects.hash(age) : 0;
        result += address != null ? Objects.hash(address) : 0;
        return result;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);


    }
}





