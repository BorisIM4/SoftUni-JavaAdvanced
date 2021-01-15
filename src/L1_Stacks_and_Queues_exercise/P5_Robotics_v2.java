package L1_Stacks_and_Queues_exercise;

import java.util.*;

public class P5_Robotics_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Robots
        String[] robots = scanner.nextLine().split(";");
        List<String> robotsAsList = Arrays.asList(robots);
        ArrayDeque<String> queueOfRobots = new ArrayDeque<>(robotsAsList);

        //Time
        int[] startTimeInArray = Arrays
                .stream(scanner
                        .nextLine()
                        .split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int hour = startTimeInArray[0];
        int minutes = startTimeInArray[1];
        int seconds = startTimeInArray[2];

        int timeInSeconds = seconds + (minutes * 60) + (hour * 3600);

        //Elements in queue
        ArrayDeque<String> queuqOfElements = new ArrayDeque<>();

        String element = scanner.nextLine();
        while (!element.equals("End")) {
            queuqOfElements.offer(element);

            element = scanner.nextLine();
        }

        //RobotsWorking
        int endTime = 0;
        while (!queuqOfElements.isEmpty()) {
            endTime++;



        }


    }
}