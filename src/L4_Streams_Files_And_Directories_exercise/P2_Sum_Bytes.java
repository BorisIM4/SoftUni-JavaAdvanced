package L4_Streams_Files_And_Directories_exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P2_Sum_Bytes {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        long sum = 0;
        byte[] values = Files.readAllBytes(pathFile);
        for (byte value : values) {
            if (value == 10 || value == 13) {
                continue;
            }
            sum += value;
        }
        System.out.println(sum);
    }
}