package L3_Sets_and_Maps_Advanced_exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P8_Hands_Of_Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = "";
        Map<String, Set<String>> playersCards = new LinkedHashMap<>();
        while (!"JOKER".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(":");
            String name = tokens[0];
            String[] cards = tokens[1].split(",\\s+");

            if (!playersCards.containsKey(name)) {
                playersCards.put(name, new HashSet<>());
            }

            for (String card : cards) {
                playersCards.get(name).add(card.trim());
            }
        }
        String regex = "([0-9]+|[JQKA])([CHDS]{1})";
        Pattern pattern = Pattern.compile(regex);

        for (Map.Entry<String, Set<String>> entry : playersCards.entrySet()) {
            String name = entry.getKey();
            int playerScores = 0;

            for (String card : entry.getValue()) {
                Matcher matcher = pattern.matcher(card);

                if (matcher.find()) {
                    String power = matcher.group(1);
                    String type = matcher.group(2);

                    int value = getValueByPower(power);
                    int multiplayer = getMultiplayerByType(type);

                    int scores = value * multiplayer;
                    playerScores += scores;
                }
            }

            System.out.println(String.format("%s: %d" ,name ,playerScores));
        }
    }

    private static int getMultiplayerByType(String type) {
        int multiplayer = 0;
        switch (type) {
            case "S":
                multiplayer = 4;
                break;
            case "H":
                multiplayer = 3;
                break;
            case "D":
                multiplayer = 2;
                break;
            case "C":
                multiplayer = 1;
                break;
        }

        return multiplayer;
    }

    private static int getValueByPower(String power) {
        int value;
        switch (power) {
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
            default:
                value = Integer.parseInt(power);
        }

        return value;
    }
}
//