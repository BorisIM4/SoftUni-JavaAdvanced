package L3_Sets_and_Maps_Advanced_exercise;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class P11_Logs_Aggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> ipLogs = new TreeMap<>();
        Map<String, Integer> durationsLogs = new TreeMap<>();

        int numberOfinputs = Integer.parseInt(scanner.nextLine());
        for (int input = 0; input < numberOfinputs; input++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String nameInput = inputData[1];
            String name = nameInput.toLowerCase();
            String ipAdress = inputData[0];
            int durationOfSession = Integer.parseInt(inputData[2]);

            if (!ipLogs.containsKey(name)) {
                ipLogs.put(name, new TreeSet<>());
                ipLogs.get(name).add(ipAdress);
                durationsLogs.put(name, durationOfSession);
            } else {
                ipLogs.get(name).add(ipAdress);
                durationsLogs.put(name, durationsLogs.get(name) + durationOfSession);
            }
        }

        durationsLogs.forEach((name, duration) -> {
            System.out.print(String.format("%s: %d " ,name ,duration));
            ipLogs.entrySet().forEach(entry -> {
                Set<String> ipadressess = entry.getValue();
                if (entry.getKey().equals(name)) {
                    String collect = ipadressess.stream().collect(Collectors.joining(", "));
                    System.out.println(String.format("[%s]" ,collect));
                }
            });
        });
    }
}
