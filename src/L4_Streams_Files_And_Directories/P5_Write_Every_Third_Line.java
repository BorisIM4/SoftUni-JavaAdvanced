package L4_Streams_Files_And_Directories;

import java.io.*;
import java.nio.Buffer;

public class P5_Write_Every_Third_Line {
    public static void main(String[] args) throws Exception {
        String path = "D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));

        BufferedWriter writer = new BufferedWriter(new FileWriter("out5.txt"));

        String line = reader.readLine();

        int lineNumebr = 1;

        while (line != null) {
            lineNumebr++;
            line = reader.readLine();

            if (lineNumebr %3 == 0) {
                writer.write(line);
                writer.newLine();
            }
        }

        writer.close();

    }
}
