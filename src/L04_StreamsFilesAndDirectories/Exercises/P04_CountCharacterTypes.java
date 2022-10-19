package L04_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '!', ',', '.', '?');

        int vowelsSum = 0;
        int punctuationsSum = 0;
        int consonants = 0;

        List<String> lines = Files.readAllLines(Path.of(path));

        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (currentChar == ' ') {
                    continue;
                }

                if (vowels.contains(currentChar)) {
                    vowelsSum++;
                } else if (punctuation.contains(currentChar)) {
                    punctuationsSum++;
                } else {
                    consonants++;
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

        writer.write("Vowels: " + vowelsSum);
        writer.newLine();
        writer.write("Consonants: " + consonants);
        writer.newLine();
        writer.write("Punctuation: " + punctuationsSum);
        writer.close();

    }
}

