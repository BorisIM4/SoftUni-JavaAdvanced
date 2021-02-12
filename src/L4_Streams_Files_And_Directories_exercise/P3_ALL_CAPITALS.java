package L4_Streams_Files_And_Directories_exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P3_ALL_CAPITALS {
    private static Object PrintWriter;

    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources");

        List<String> lines = Files.readAllLines(pathFile);
        File outPutFile = new File("exerOut3.txt");
        PrintWriter writer = new PrintWriter(outPutFile);
        lines.forEach(line -> writer.println(line.toUpperCase()));
        writer.close();
    }
}
