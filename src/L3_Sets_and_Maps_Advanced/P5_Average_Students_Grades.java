package L3_Sets_and_Maps_Advanced;

import java.util.*;
import java.util.stream.Collectors;

public class P5_Average_Students_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> gradesOFStudentMap = new TreeMap<>();

        for (int input = 0; input < numberOfInputs; input++) {
            String[] studentTokenArr = scanner.nextLine().split("\\s+");
            String studentName = studentTokenArr[0];
            Double studentGrade = Double.parseDouble(studentTokenArr[1]);

            gradesOFStudentMap.putIfAbsent(studentName, new LinkedList<>());
            gradesOFStudentMap.get(studentName).add(studentGrade);

        }

        gradesOFStudentMap.forEach((student, grade) -> {
            System.out.print(student + " -> ");
            grade.forEach(v -> {
                System.out.printf("%.2f ",v);
            });
            double sum = 0;
            for (int i = 0; i < grade.size(); i++) {
                sum += grade.get(i);
            }
            double average = sum / grade.size();
            System.out.printf("(avg: %.2f)%n",average);

        });

    }
}
