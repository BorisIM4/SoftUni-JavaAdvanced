package L6_Defining_Classes_exercise.P1_Opinion_Poll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] token = scanner.nextLine().split("\\s+");

            String name = token[0];
            int age = Integer.parseInt(token[1]);

            Person p = new Person(name, age);

            people.add(p);

        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> System.out.println(String.format("%s - %d",
                        person.getName(),
                        person.getAge())));


    }
}
