package L4_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P9_Serialize_Custom_Object {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String fileName = "D:" +
                "/Programirane" +
                "/Java" +
                "/SoftUni" +
                "/03-SU-Java-Advanced-2021-01" +
                "/04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "/Files-and-Streams";

        List<String> names = new ArrayList<>();

        names.add("Martin");
        names.add("Pesho");
        names.add("Gosho");
        names.add("Bobi");

        ObjectOutputStream outputStream =
                new ObjectOutputStream(new FileOutputStream("list.txt"));

        outputStream.writeObject(names);

        outputStream.close();

        ObjectInputStream inputStream =
                new ObjectInputStream(new FileInputStream("list.txt"));

        List<String> readedNames = (List<String>)inputStream.readObject();

        for (String name : readedNames) {
            System.out.println(name);

        }
    }
}
