package L4_Streams_Files_And_Directories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P5_Write_Every_Third_Line_v2 {
    public static void main(String[] args) throws Exception {
        String fileName = "D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        List<String> strings = Files.readAllLines(Path.of(fileName));

        List<String> lines = new ArrayList<>();

        for (int i = 2; i < strings.size(); i+=3) {
            lines.add(strings.get(i));

        }
        Files.write(Path.of("out5v2.txt")
                ,lines, StandardCharsets.UTF_8);

    }
}
