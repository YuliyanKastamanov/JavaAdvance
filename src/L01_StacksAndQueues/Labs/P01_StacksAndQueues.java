package L01_StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_StacksAndQueues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ArrayDeque<String> urls = new ArrayDeque<>();

        while (!command.equals("Home")){
            boolean isBack = false;
            switch (command){
                case "back":
                    isBack = true;
                    if (urls.size()>1){
                        urls.pop();
                        System.out.println(urls.peek());
                    } else {
                        System.out.println("no previous URLs");
                    }
                    break;
            }
            if(!isBack){
                urls.push(command);
                System.out.println(command);
            }

           command = scanner.nextLine();
        }

    }
}
