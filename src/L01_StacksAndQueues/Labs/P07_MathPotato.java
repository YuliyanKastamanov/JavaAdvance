package L01_StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.valueOf(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, children);


        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 0; i < n -1; i++) {
                queue.offer(queue.poll());
            }
                if (isPrime(cycle)) {
                    System.out.println("Prime " + queue.peek());
                } else {
                    System.out.println("Removed " + queue.poll());
                }


            cycle++;
        }
        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int count){

        if (count == 1){
            return false;
        }

        for (int i = 2; i < count; i++) {

            if (count % i == 0 ){
                return false;
            }

        }


        return true;
    }
}
