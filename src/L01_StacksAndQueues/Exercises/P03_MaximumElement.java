package L01_StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= number ; i++) {
            String command = scanner.nextLine();

            if (command.equals("2")) {

                stack.pop();

            } else if (command.equals("3")) {
                if (!stack.isEmpty()){
                    System.out.println(Collections.max(stack));
                }

            }else {
                int numberToPush = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(numberToPush);
            }



        }
    }
}
