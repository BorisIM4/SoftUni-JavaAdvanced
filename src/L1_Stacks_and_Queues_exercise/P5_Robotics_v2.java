package L1_Stacks_and_Queues_exercise;

import java.util.*;

public class P5_Robotics_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Robots
        String[] robotsAsStringArr = scanner.nextLine().split(";");
        List<String> robots = Arrays.asList(robotsAsStringArr);

        String[] names = new String[robots.size()];
        int[] processTime = new int[robots.size()];

        for (int i = 0; i < robots.size(); i++) {
            String[] tokens = robots.get(i).split("-");
            String name = tokens[0];
            names[i] = name;
            int time = Integer.parseInt(tokens[1]);
            processTime[i] = time;
        }

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
        int startTimeInSeconds = seconds + (minutes * 60) + (hour * 3600);

        //Elements in queue
        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        String inputProduct;
        while (!"End".equals(inputProduct = scanner.nextLine())) {
            productsQueue.offer(inputProduct);
        }

        int[] robotWorkLeft = new int[robots.size()];

        //RobotsWorking
        while (!productsQueue.isEmpty()) {
            startTimeInSeconds++;
            String product = productsQueue.poll();
            int index = -1;

            for (int i = 0; i < robotWorkLeft.length; i++) {
                if (robotWorkLeft[i] > 0) {
                    robotWorkLeft[i]--;
                }

                if (robotWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                robotWorkLeft[index] = processTime[index];
                System.out.println(printRobotData(names[index], product, startTimeInSeconds));
            } else {
                productsQueue.offer(product);
            }
        }
    }

    private static String printRobotData(String robot, String product, int beginTime) {
        long seconds = beginTime % 60;
        long minutes = (beginTime / 60) % 60;
        long hours = (beginTime / (60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d",hours ,minutes ,seconds);

        return String.format("%s - %s [%s]", robot, product, time);
    }
}