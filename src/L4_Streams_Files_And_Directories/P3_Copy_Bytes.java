package L4_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class P3_Copy_Bytes {
    public static void main(String[] args) throws Exception {
        String path = "D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("out3.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();

        while (singleByte >= 0) {


            if (singleByte == 10 || singleByte == 32) {
                writer.print((char)singleByte);
            }else {
                writer.print(singleByte);
            }

            singleByte = inputStream.read();
        }
        writer.close();

        inputStream.close();

    }
}
