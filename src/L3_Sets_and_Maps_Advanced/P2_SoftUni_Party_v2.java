package L3_Sets_and_Maps_Advanced;

import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class P2_SoftUni_Party_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("party")) {

            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }
            input = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        vip.addAll(regular);
        //System.out.println(vip.stream().collect(Collectors.joining(System.lineSeparator())));
        //System.out.println(regular.stream().collect(Collectors.joining(System.lineSeparator())));

        vip.forEach(System.out::println);
    }
}
