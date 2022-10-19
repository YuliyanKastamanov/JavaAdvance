package L04_StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        byte [] allBytesArr = Files.readAllBytes(Path.of(path));

        long sum = 0;

        for (byte ascii : allBytesArr) {
            if (ascii != 10 && ascii != 13) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
