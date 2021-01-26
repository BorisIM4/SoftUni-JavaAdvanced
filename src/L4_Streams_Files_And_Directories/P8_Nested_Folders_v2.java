package L4_Streams_Files_And_Directories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P8_Nested_Folders_v2 {

    public static int foldersCount = 0;

    public static void main(String[] args) {
        String fileName = "D:" +
                "/Programirane" +
                "/Java" +
                "/SoftUni" +
                "/03-SU-Java-Advanced-2021-01" +
                "/04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "/Files-and-Streams";

        File file = new File(fileName);

        dfs(file);

        System.out.println(foldersCount + " folders");
    }

    public static void dfs (File file) {
        // Bottome case
        // Step
        foldersCount++;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                dfs(f);
            }
        }
        System.out.println(file.getName());
    }
}
