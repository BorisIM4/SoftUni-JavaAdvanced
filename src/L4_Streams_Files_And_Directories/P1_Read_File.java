package L4_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class P1_Read_File {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "D:\\Programirane\\Java\\SoftUni\\03. SU-Java_Advanced-2019-05\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);

        int letterAsInteger = fileStream.read();
            while (letterAsInteger != -1){
                System.out.print(Integer.toBinaryString(letterAsInteger) + " ");
                letterAsInteger = fileStream.read();
        }
    }
}
