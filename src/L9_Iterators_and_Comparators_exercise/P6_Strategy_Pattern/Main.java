package L9_Iterators_and_Comparators_exercise.P6_Strategy_Pattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleByName = new TreeSet<>(new ComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            peopleByName.add(person);
            peopleByAge.add(person);
        }

        peopleByName.forEach(p -> System.out.println(p.toString()));
        peopleByAge.forEach(p -> System.out.println(p.toString()));
    }
}
