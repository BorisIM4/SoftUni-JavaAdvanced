package L8_Generics_exercise.P10_Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        String name = String.format("%s %s" ,tokens[0], tokens[1]);
        String address = tokens[2];
        Tuple<String, String > personInDetails = new Tuple<>(name, address);
        System.out.println(personInDetails);

        tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        Tuple<String, Integer> personBeer = new Tuple<>(name, liters);
        System.out.println(personBeer);

        tokens = scanner.nextLine().split("\\s+");
        int intNum = Integer.parseInt(tokens[0]);
        double floatnum = Double.parseDouble(tokens[1]);
        Tuple<Integer, Double> numbrrs = new Tuple<>(intNum, floatnum);
        System.out.println(numbrrs);
    }
}
