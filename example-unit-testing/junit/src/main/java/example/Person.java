package example;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null)
            throw new IllegalArgumentException("example.Person's name can't be null");
        if ("".equals(name))
            throw new IllegalArgumentException("example.Person's name can't be empty");
        if (age < 0)
            throw new IllegalArgumentException("example.Person's age can't be less than zero");
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "example.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
