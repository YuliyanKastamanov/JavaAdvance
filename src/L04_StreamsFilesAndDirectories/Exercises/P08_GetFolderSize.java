package L04_StreamsFilesAndDirectories.Exercises;

import java.io.File;
import java.nio.file.Files;

public class P08_GetFolderSize {
    public static void main(String[] args) {



    String path = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

    File folder = new File(path);

    File[] allFiles = folder.listFiles();

        int folderSize = 0; //размер на папката
        for (File file : allFiles) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);

    }
}