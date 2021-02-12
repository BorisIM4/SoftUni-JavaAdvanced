package L4_Streams_Files_And_Directories_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P1_Sum_Lines_v2 {
    public static void main(String[] args) throws IOException {

        Path pathFile = Path.of("D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt");

        List<String> lines = Files.readAllLines(pathFile);
        lines.stream().map(String::toCharArray)
                .forEach(charArray -> {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}