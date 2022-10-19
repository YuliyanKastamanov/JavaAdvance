package L04_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06_WordCount {
    public static void main(String[] args) throws IOException {

        String pathWords = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathTwo = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        //BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

        Map<String, Integer> countWords = new HashMap<>();

        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));
        for (String lineWithWords : allLinesWithWords) {
            //lineWithWords = "of which The".split("\\s+") -> ["of", "which", "The"]
            Arrays.stream(lineWithWords.split("\\s+")).forEach(
                    word -> {
                        countWords.put(word, 0);
                    }
            );
        }

        List<String> allLines = Files.readAllLines(Path.of(pathTwo));
        for (String line : allLines) {
            //line = "There are many variations".split("\\s+") -> []
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                        if (countWords.containsKey(word)) {
                            int currentCount = countWords.get(word);
                            countWords.put(word, currentCount + 1);
                        }
                    }
            );

        }
        PrintWriter writer = new PrintWriter("C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
        //compareTo -> 0 (първото == второто), 1 (първото > второто), -1 (второто > първото)
        //sorted -> 0 (не разменя местата на записите), 1 (разменя местата на първото и второто), -1 (не разменя местата на записите)



    }
}
