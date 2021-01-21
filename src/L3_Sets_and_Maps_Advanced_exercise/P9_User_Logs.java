package L3_Sets_and_Maps_Advanced_exercise;

import java.util.*;

public class P9_User_Logs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userInfo = new TreeMap<>();

        String line = "";

        while (!"end".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];

            userInfo.putIfAbsent(username, new LinkedHashMap<>());
            userInfo.get(username).putIfAbsent(ip, 0);
            userInfo.get(username).put(ip, userInfo.get(username).get(ip) + 1);
        }
        for (Map.Entry<String, Map<String, Integer>> entry : userInfo.entrySet()) {
            System.out.println(entry.getKey() + ":");
            Map<String, Integer> innermap = entry.getValue();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> innerEntry : innermap.entrySet()) {
                String ipInfo = String.format("%s => %d", innerEntry.getKey(), innerEntry.getValue());
                sb.append(ipInfo);
                sb.append(", ");
            }
            String res = sb.substring(0, sb.length()-2);
            System.out.println(res + ".");
        }
    }
}
