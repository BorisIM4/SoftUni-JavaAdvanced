package L4_Streams_Files_And_Directories;

import java.io.File;
import java.nio.file.Files;

public class P7_List_Files {
    public static void main(String[] args) throws Exception {
        String fileName = "D:/Programirane" +
                "/Java" +
                "/SoftUni" +
                "/03-SU-Java-Advanced-2021-01" +
                "/04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "/Files-and-Streams/input.txt";

        File files = new File(fileName);

        File[] innnerFiles = files.listFiles();

        for (File innerFile:innnerFiles) {
            if (!innerFile.isFile()) {
                System.out.printf("%s: [%d]%n"
                        ,innerFile.getName()
                        ,innerFile.length());
            }
        }

    }
}
