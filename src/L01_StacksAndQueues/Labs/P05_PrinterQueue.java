package L01_StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!command.equals("print")){

            if (!command.equals("cancel")){
                queue.offer(command);
            } else {
                if(queue.size() > 0){
                    System.out.println("Canceled " + queue.remove());
                } else {
                    System.out.println("Printer is on standby");
                }
            }

            command = scanner.nextLine();
        }

        for (String dox : queue) {

            System.out.println(dox);
            
        }



    }
}
