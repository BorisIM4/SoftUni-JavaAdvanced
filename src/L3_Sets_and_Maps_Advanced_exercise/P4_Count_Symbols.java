package L3_Sets_and_Maps_Advanced_exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P4_Count_Symbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> map = new TreeMap<>();

        for (int symbols = 0; symbols < input.length(); symbols++) {
            char currentChar = input.charAt(symbols);

            map.putIfAbsent(currentChar, 0);
            map.put(currentChar, map.get(currentChar) + 1);
        }

        map.forEach((symbol, sum) -> {
            System.out.printf("%c: %d time/s%n" ,symbol ,sum);
        });
    }
}
