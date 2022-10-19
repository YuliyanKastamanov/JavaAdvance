package L04_StreamsFilesAndDirectories.Labs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_WriteFile {
    public static void main(String[] args) throws IOException {


        String pathIn = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        Set<Character> forbiddenChars = new HashSet<>();
        Collections.addAll(forbiddenChars, ',', '.', '!', '?');

        FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut);
            int oneByte = in.read();
            while (oneByte >= 0){
                char myByteAsChar = (char) oneByte;
                if (!forbiddenChars.contains(myByteAsChar)) {
                    out.write(oneByte);
                }
                oneByte = in.read();
            }


    }
}
