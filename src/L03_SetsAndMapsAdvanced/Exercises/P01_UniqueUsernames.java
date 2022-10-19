package L03_SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class P01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < number; i++) {
            String currentUsername = scanner.nextLine();
            usernames.add(currentUsername);

        }

        for (String name : usernames) {

            System.out.println(name);

        }
    }
}
