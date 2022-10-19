package L01_StacksAndQueues.Exercises;

import java.util.Scanner;

public class P06_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int position = Integer.parseInt(scanner.nextLine());

        long first = 0;
        long second = 1;
        long third = first + second;

        for (int i = 1; i <= position; i++) {
            first = second;
            second = third;
            third = first + second;
        }
        System.out.println(second);


    }
}
