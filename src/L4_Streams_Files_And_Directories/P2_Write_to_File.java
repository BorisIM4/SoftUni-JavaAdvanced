package L4_Streams_Files_And_Directories;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P2_Write_to_File {
    public static void main(String[] args) throws Exception {
        String path = "D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("out2.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();

        //Table ',', '.', '!', '?'
        Set<Character> puctuations = new HashSet<>();
        puctuations.add(',');
        puctuations.add('.');
        puctuations.add('!');
        puctuations.add('?');

        while (singleByte >= 0) {

            char symbol = (char) singleByte;

            if (!puctuations.contains(symbol)) {
                writer.print(symbol);
            }

            singleByte = inputStream.read();
        }
        writer.close();
        inputStream.close();
    }
}
