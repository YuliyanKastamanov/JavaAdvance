package L01_StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.valueOf(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if(number == 0){
            System.out.println(number);
        }else {
            while (number != 0){
                stack.push(number % 2);
                number /= 2;
            }

            while (!stack.isEmpty()){
                System.out.print(stack.pop());
            }
        }

    }
}
