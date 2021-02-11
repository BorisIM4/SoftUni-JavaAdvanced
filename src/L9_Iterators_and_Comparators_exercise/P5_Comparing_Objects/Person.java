package L9_Iterators_and_Comparators_exercise.P5_Comparing_Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String city) {
        this.name = name;
        setAge(age);
        this.town = city;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(" You can not create person with negative age");
        }
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.name);

        if (result == 0) {
            result = Integer.compare(this.age, o.age);
            if (result == 0) {
                result = this.town.compareTo(o.town);
            }
        }
        return result;
    }
}
