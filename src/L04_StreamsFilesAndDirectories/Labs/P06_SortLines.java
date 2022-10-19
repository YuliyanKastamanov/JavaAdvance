package L04_StreamsFilesAndDirectories.Labs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06_SortLines {
    public static void main(String[] args) throws IOException {



        String inPath = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        Path input = Paths.get(inPath);
        Path output = Paths.get(outPath);

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        Files.write(output, lines);

    }
}
