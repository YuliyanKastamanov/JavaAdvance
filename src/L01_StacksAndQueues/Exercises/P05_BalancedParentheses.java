package L01_StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stackOpenBrackets = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if(currentChar == '(' || currentChar == '{' || currentChar == '['){
                stackOpenBrackets.push(currentChar);
            } else if(currentChar == ')' || currentChar == '}' || currentChar == ']'){

                if (stackOpenBrackets.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = stackOpenBrackets.pop();

                if (lastOpenBracket == '(' && currentChar == ')') {

                    areBalanced = true;
                }else if(lastOpenBracket == '{' && currentChar == '}'){
                    areBalanced = true;
                }else if (lastOpenBracket == '[' && currentChar == ']'){
                    areBalanced = true;
                }else {
                    areBalanced = false;
                    break;
                }

            }


        }

        if (areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
