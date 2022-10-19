package L01_StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, tokens);

        while (stack.size()>1){
            int firstNumber = Integer.valueOf(stack.pop());
            String operation = stack.pop();
            int secondNumber = Integer.valueOf(stack.pop());

            switch (operation){
                case "+":
                    stack.push(String.valueOf(firstNumber + secondNumber));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNumber - secondNumber));
                    break;
            }
        }

        System.out.println(stack.peek());



    }
}
