package L4_Streams_Files_And_Directories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P8_Nested_Folders {
    public static void main(String[] args) {
        String fileName = "D:" +
                "/Programirane" +
                "/Java" +
                "/SoftUni" +
                "/03-SU-Java-Advanced-2021-01" +
                "/04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "/Files-and-Streams";

        File file = new File(fileName);

        Deque<File> directories = new ArrayDeque<>();
        directories.offer(file);

        int count = 0;
        while (!directories.isEmpty()) {
            File currenetFile= directories.poll();
            File[] nestedFiles = currenetFile.listFiles();

            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    directories.offer(nestedFile);
                }

            }
            count++;
            System.out.println(currenetFile.getName());
        }
        System.out.println(count + " folders");

    }
}
