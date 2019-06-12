package L6_Defining_Classes_exercise.P3_Speed_Racing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter start number: ");
        int startNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter multiply number: ");
        int multiplayer = Integer.parseInt(scanner.nextLine());
        System.out.println("How many times to do this operation: ");
        int numberOfRotation = Integer.parseInt(scanner.nextLine());

        ClassOne firstClass = new ClassOne();

        //set start number in classTwo
        firstClass.getClassTwo().setStartnumber(startNumber);

        //set multiplay number in ClassThree
        firstClass.getClassTwo().getClassThree().setMultiplayer(multiplayer);

        //set how many times to rotate for loop
        firstClass.getClassTwo().getClassThree().setNumberOfRotation(numberOfRotation);

        int thisIsGetFromClassThree = firstClass.getClassTwo().getClassThree().getNumberOfRotation();
        for (int i = 0; i < thisIsGetFromClassThree; i++) {
            int currentStartPosition = firstClass.getClassTwo().getStartNumber();
            int currnetMultiplayher = firstClass.getClassTwo().getClassThree().getMultiplayer();

            currentStartPosition *= currnetMultiplayher;

            firstClass.getClassTwo().setStartnumber(currentStartPosition);

            System.out.println(currentStartPosition);
        }

    }
}
