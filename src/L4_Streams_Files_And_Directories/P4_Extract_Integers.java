package L4_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P4_Extract_Integers {
    public static void main(String[] args) throws Exception {
        String path = "D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        FileWriter writer =  new FileWriter("out4.txt");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.write(String.valueOf(number));
                writer.write(System.lineSeparator());
            }
            scanner.next();
        }

        writer.flush();
        writer.close();
    }
}
