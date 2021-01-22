package L4_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class P1_Read_File_v2 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int singleByte = inputStream.read();

        while (singleByte >= 0) {
            System.out.print(Integer.toBinaryString(singleByte) + " ");

            singleByte = inputStream.read();
        }

        inputStream.close();
    }
}
