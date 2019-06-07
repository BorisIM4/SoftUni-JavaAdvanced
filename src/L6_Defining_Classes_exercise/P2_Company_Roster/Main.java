package L6_Defining_Classes_exercise.P2_Company_Roster;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Department> departments = new HashMap<>();

        while (n-- > 0 ){
            String[] token = scanner.nextLine().split("\\s+");

            String departmentName = token[3];

            Employee emp = new Employee(
                    token[0],
                    Double.parseDouble(token[1]),
                    token[2]
            );

            if (token.length == 5) {
                if (Character.isDigit(token[4].charAt(0))){
                    emp.setAge(Integer.parseInt(token[4]));

                }else {
                    emp.setEmail(token[4]);
                }
            }else  if (token.length == 6) {
                emp.setEmail(token[4]);
                emp.setAge(Integer.parseInt(token[5]));
            }

            if (departments.containsKey(departmentName)){

            }

        }

    }
}

