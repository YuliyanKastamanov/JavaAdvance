package L04_StreamsFilesAndDirectories.Labs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";


        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        FileOutputStream fileOutputStream = new FileOutputStream(pathOut);
        PrintWriter myFileOutput = new PrintWriter(fileOutputStream);

        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int myNumber = scanner.nextInt();

                myFileOutput.println(myNumber);
            }
            scanner.next();
        }

        myFileOutput.close();
    }
}
