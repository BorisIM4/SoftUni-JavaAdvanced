package L4_Streams_Files_And_Directories_exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P2_Sum_Bytes {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\lord_\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        String outPutPath = filePath.substring(0 ,filePath.lastIndexOf("\\") + 1) + "zadacha_2.txt";

        FileWriter writer = writer = new FileWriter(outPutPath);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            int asciiSum = 0;
            while (line != null) {

                for (char symbol : line.toCharArray()) {
                    asciiSum += symbol;
                }


                line = reader.readLine();
            }

            writer.write(asciiSum + "");
            writer.write(System.lineSeparator());

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        writer.close();
    }
}
