package L04_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathOne = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathTwo = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        List<String> linesOne = Files.readAllLines(Path.of(pathOne));
        List<String> linesTwo = Files.readAllLines(Path.of(pathTwo));

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

        linesOne.stream().forEach(line -> {
            try {
                writer.write(line);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        linesTwo.stream().forEach(line -> {
            try {
                writer.write(line);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();

    }
}
