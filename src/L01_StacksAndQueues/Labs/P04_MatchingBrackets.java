package L01_StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <input.length() ; i++) {

            char currentChar = input.charAt(i);

            if (currentChar == '('){
                stack.push(i);
            } else if(currentChar == ')'){
                int startIndex = stack.pop();
                String contents = input.substring(startIndex, i + 1);
                System.out.println(contents);
            }

        }


    }
}
