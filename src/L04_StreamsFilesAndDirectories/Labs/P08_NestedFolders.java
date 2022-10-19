package L04_StreamsFilesAndDirectories.Labs;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08_NestedFolders {

    public static void main(String[] args) {


        String path = "C:\\Users\\myrdo\\IdeaProjects\\JavaAdvance\\src\\L04_StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int count = 0;

        while (!dirs.isEmpty()){
            File currentFile = dirs.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File nestedFile: nestedFiles) {
                if (nestedFile.isDirectory()){
                    dirs.offer(nestedFile);

                }
            }
            count ++;
            System.out.println(currentFile.getName());
        }
        System.out.println(count + " folders");

    }
}
