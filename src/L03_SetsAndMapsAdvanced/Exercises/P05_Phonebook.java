package L03_SetsAndMapsAdvanced.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!data.equals("search")){

            String currentName = data.split("-")[0];
            String currentNum = data.split("-")[1];

            phonebook.put(currentName, currentNum);

            data = scanner.nextLine();


        }

        String command = scanner.nextLine();

        while (!command.equals("stop")){
            if(phonebook.containsKey(command)){
                System.out.printf("%s -> %s%n", command, phonebook.get(command));
            }else {
                System.out.printf("Contact %s does not exist.%n", command);
            }

            command = scanner.nextLine();
        }
    }
}
