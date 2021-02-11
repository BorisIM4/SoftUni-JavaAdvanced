package L9_Iterators_and_Comparators_exercise.P4_Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] stones = Arrays
                .stream(scanner
                        .nextLine()
                        .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(stones);
        Iterator<Integer> froggy = lake.iterator();

        List<String> result = new ArrayList<>();
        while (froggy.hasNext()) {
            result.add(froggy.next() + "");
        }

        System.out.println(String.join(", " ,result));
    }
}
