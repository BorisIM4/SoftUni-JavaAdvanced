package L10_Exam_Preparation_Two.Exam_2019_12_17.P1_Santa_Present_Factory;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//Doll	150
//Wooden train	250
//Teddy bear	300
//Bicycle 	400

        Deque<Integer> materialsStack = new ArrayDeque<>();
        Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(materialsStack::push);

        Deque<Integer> magixQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(magixQueue::offer);

        Map<String, Integer> presentsMap = new TreeMap<>();
        presentsMap.put("Doll", 0);
        presentsMap.put("Wooden train", 0);
        presentsMap.put("Teddy bear", 0);
        presentsMap.put("Bicycle", 0);

        Map<Integer, String> templateMap = new HashMap<>();
        templateMap.put(150, "Doll");
        templateMap.put(250, "Wooden train");
        templateMap.put(300, "Teddy bear");
        templateMap.put(400, "Bicycle");

        while (!materialsStack.isEmpty() && !magixQueue.isEmpty()) {
            int currentMaterial = materialsStack.peek();
            int currentMagic = magixQueue.peek();

            int magic = currentMaterial * currentMagic;

            if (templateMap.containsKey(magic)) {
                materialsStack.pop();
                magixQueue.poll();

                int currentPresentCount = presentsMap.get(templateMap.get(magic));
                presentsMap.put(templateMap.get(magic), currentPresentCount + 1);
            } else if (magic < 0) {
                int magicAsSum = currentMaterial + currentMagic;
                materialsStack.pop();
                magixQueue.poll();
                materialsStack.push(magicAsSum);
            } else if (magic > 0) {
                magixQueue.poll();
                int removeCurrentMaterialo = materialsStack.pop();
                materialsStack.push(removeCurrentMaterialo + 15);
            } else if (magic == 0) {
                if (currentMaterial == 0) {
                    materialsStack.pop();
                }
                if (currentMagic == 0) {
                    magixQueue.poll();
                }
            }
        }

        if (isJobDone(presentsMap)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialsStack.isEmpty()) {
            String materialsAsString = materialsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Materials left: %s%n" ,materialsAsString);
        }
        if (!magixQueue.isEmpty()) {
            String magicAsString = magixQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Magic left: %s%n" ,magicAsString);
        }
        presentsMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> {
            String presentName = entry.getKey();
            int presentCount = entry.getValue();
            System.out.printf("%s: %d%n" ,presentName, presentCount);
        });
    }

    private static boolean isJobDone(Map<String, Integer> presentsMap) {
        boolean flag = false;
        if (presentsMap.get("Doll") > 0 && presentsMap.get("Wooden train") > 0) {
            flag = true;
        } else if (presentsMap.get("Teddy bear") > 0 && presentsMap.get("Bicycle") > 0) {
            flag = true;
        }
        return flag;
    }
}
