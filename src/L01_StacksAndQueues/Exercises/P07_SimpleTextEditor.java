package L01_StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());;
        ArrayDeque<String> wordStates = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= number ; i++) {
            String command = scanner.nextLine();
            String commandNumber = command.split("\\s+")[0];


            switch (commandNumber){
                case "1":
                    String textToAdd = command.split("\\s+")[1];
                    text.append(textToAdd);
                    wordStates.push(text.toString());
                    break;

                case "2":
                    int count = Integer.parseInt(command.split("\\s+")[1]);
                    int startIndex = text.length() - count;
                    text.delete(startIndex, startIndex + count);
                    wordStates.push(text.toString());
                    break;

                case "3":
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if(wordStates.size() > 1){
                        wordStates.pop();
                        text = new StringBuilder(wordStates.peek());
                    }else {
                        text = new StringBuilder();
                    }
                    break;
            }

        }
    }
}
