package L3_Sets_and_Maps_Advanced;

import java.util.Scanner;
import java.util.TreeSet;

public class P2_SoftUni_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> partyList = new TreeSet<>();

        String input;

        while (!(input = scanner.nextLine()).equals("PARTY")){
            partyList.add(input);

        }

        while (!(input = scanner.nextLine()).equals("END")){
            if (partyList.contains(input)){
                partyList.remove(input);
            }
        }

        System.out.println(partyList.size());
        for (String names : partyList) {
            System.out.println(names);
        }
    }
}
