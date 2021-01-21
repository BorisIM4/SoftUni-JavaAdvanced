package L3_Sets_and_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P6_Product_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> mapOfShops = new TreeMap<>();

        while (!"Revision".equals(input)) {
            String[] tokens = input.split(", ");
            String shopName = tokens[0];
            String productName = tokens[1];
            double priceOfProduct = Double.parseDouble(tokens[2]);

            mapOfShops.putIfAbsent(shopName, new LinkedHashMap<>());
            mapOfShops.get(shopName).putIfAbsent(productName, priceOfProduct);

            input = scanner.nextLine();
        }

        mapOfShops.forEach((shop, value) -> {
            System.out.printf("%s->%n",shop);
            value.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f%n" ,product ,price);
            });
        });
    }
}
