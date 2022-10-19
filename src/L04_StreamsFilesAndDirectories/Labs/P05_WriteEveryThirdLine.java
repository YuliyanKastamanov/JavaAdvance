package L04_StreamsFilesAndDirectories.Labs;

import java.io.*;
import java.util.Scanner;

public class P05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {


        String inPath = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";


        Scanner in = new Scanner(new FileInputStream(inPath));
        PrintWriter out = new PrintWriter(new FileWriter(outPath));

        int counter = 1;

        String  line = in.nextLine();
        while (in.hasNextLine()){

            if (counter % 3 == 0){
                out.println(line);
            }
            counter++;
            line = in.nextLine();
            out.flush();

        }
        out.close();
        in.close();


    }
}
