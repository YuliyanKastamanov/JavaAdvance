package L04_StreamsFilesAndDirectories.Labs;

import java.io.File;
import java.io.IOException;

public class P07_ListFiles {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");


        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files) {

                    if (!f.isDirectory()){
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                    
                }
            }
        }



    }
}
