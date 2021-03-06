package L4_Streams_Files_And_Directories_exercise;

import java.io.*;

public class P1_Sum_Lines {
    public static void main(String[] args) throws IOException {

        String filePath = "D:\\Programirane\\Java\\SoftUni\\03-SU-Java-Advanced-2021-01\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outPutPath = filePath.substring(0 ,filePath.lastIndexOf("\\") + 1) + "asciSum.txt";

        FileWriter writer = writer = new FileWriter(outPutPath);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) {
                int asciiSum = 0;
                for (char symbol : line.toCharArray()) {
                    asciiSum += symbol;
                }

                writer.write(asciiSum + "");
                writer.write(System.lineSeparator());

                line = reader.readLine();
            }

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        writer.close();

    }
}
