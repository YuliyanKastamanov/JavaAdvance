package L04_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03_AllCapital {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> lines = Files.readAllLines(Path.of(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

        for (String line : lines) {

            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
    }
}
