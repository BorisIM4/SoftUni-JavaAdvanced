package L3_Sets_and_Maps_Advanced;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P8_Academy_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOdInputs = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> mapOfStudents = new TreeMap<>();

        for (int input = 0; input < numberOdInputs; input++) {
            String studentName = scanner.nextLine();
            List<Double> gradesOfStudent = Arrays
                    .stream(scanner
                            .nextLine()
                            .split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors
                            .toList());

            mapOfStudents.putIfAbsent(studentName, new ArrayList<>());
            mapOfStudents.put(studentName, gradesOfStudent);

        }

        DecimalFormat df = new DecimalFormat("###.################");

        mapOfStudents.entrySet().stream().forEach(entry -> {
            double sum = 0;
            for (Double grade:entry.getValue()) {
                sum += grade;
            }
            double avg = sum / entry.getValue().size();
            System.out.println(String.format("%s is graduated with %s" ,entry.getKey()
            ,df.format(avg)));
        });
    }
}
