package L7_Workshop.P1_Implement_the_SmartArray_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 10; i++) {
            smartArray.add(i);
        }

        smartArray.forEach(e -> System.out.println("This number:" + e));

        for (int i = 0; i < smartArray.size(); i++) {
            smartArray.remove(0);
        }

        smartArray.forEach(System.out::println);
    }
}
