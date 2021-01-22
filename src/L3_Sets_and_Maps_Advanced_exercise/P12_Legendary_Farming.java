package L3_Sets_and_Maps_Advanced_exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P12_Legendary_Farming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> importantMaterials = new HashMap<>();
        Map<String, Integer> restMaterials = new HashMap<>();

        importantMaterials.put("shards",0);
        importantMaterials.put("fragments",0);
        importantMaterials.put("motes",0);
        printElsematerials(restMaterials);


        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i+=2) {
                int cuantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();


                if ("shards".equals(material)) {
                    //importantMaterials.putIfAbsent(material, 0);
                    importantMaterials.put(material, importantMaterials.get(material) + cuantity);
                    int currentCuantity = importantMaterials.get(material);
                    if (currentCuantity >= 250) {
                        importantMaterials.put(material, importantMaterials.get(material) - 250);
                        System.out.println("Shadowmourne obtained!");
                        printImportantMaterials(importantMaterials);
                        printElsematerials(restMaterials);
                        return;
                    }

                } else if ("fragments".equals(material)) {
                    //importantMaterials.putIfAbsent(material, 0);
                    importantMaterials.put(material, importantMaterials.get(material) + cuantity);
                    int currentCuantity = importantMaterials.get(material);
                    if (currentCuantity >= 250) {
                        importantMaterials.put(material, importantMaterials.get(material) - 250);
                        System.out.println("Valanyr obtained!");
                        printImportantMaterials(importantMaterials);
                        printElsematerials(restMaterials);
                        return;
                    }

                } else if ("motes".equals(material)) {
                    //importantMaterials.putIfAbsent(material, 0);
                    importantMaterials.put(material, importantMaterials.get(material) + cuantity);
                    int currentCuantity = importantMaterials.get(material);
                    if (currentCuantity >= 250) {
                        importantMaterials.put(material, importantMaterials.get(material) - 250);
                        System.out.println("Dragonwrath obtained!");
                        printImportantMaterials(importantMaterials);
                        printElsematerials(restMaterials);
                        return;
                    }

                } else {
                    restMaterials.putIfAbsent(material, 0);
                    restMaterials.put(material, restMaterials.get(material) + cuantity);
                }
            }
        }
    }

    private static void printElsematerials(Map<String, Integer> restMaterials) {
        restMaterials.entrySet().stream().sorted((material1, material2) -> {
            String name1 = material1.getKey();
            String name2 = material2.getKey();
            return name1.compareTo(name2);
        }).forEach(material -> {
            String name = material.getKey();
            int quantity = material.getValue();
            System.out.println(String.format("%s: %d" ,name, quantity));
        });
    }

    private static void printImportantMaterials(Map<String, Integer> importantMaterials) {
        importantMaterials.entrySet().stream().sorted((material1, material2) -> {
            int quantity1 = material1.getValue();
            int quantity2 = material2.getValue();
            if (quantity1 == quantity2) {
                String name1 = material1.getKey();
                String name2 = material2.getKey();
                return name1.compareTo(name2);
            }
            return Integer.compare(quantity2, quantity1);
        }).forEach(material -> {
            String name = material.getKey();
            int quantity = material.getValue();
            System.out.println(String.format("%s: %d" ,name, quantity));
        });
    }
}
