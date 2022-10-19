package L04_StreamsFilesAndDirectories.Labs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01_ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        try (FileInputStream fileStream  = new FileInputStream(path)){

            int oneBite = fileStream.read();
            while (oneBite >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneBite));
                oneBite = fileStream.read();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
