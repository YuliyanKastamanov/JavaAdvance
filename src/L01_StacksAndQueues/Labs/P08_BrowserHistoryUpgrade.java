package L01_StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> urls = new ArrayDeque<>();
        ArrayDeque<String> forwardUrls = new ArrayDeque<>();

        while (!command.equals("Home")){
            boolean isBack = false;
            switch (command){
                case "back":
                    isBack = true;
                    if (urls.size()>1){
                        String fwdURL = urls.pop();
                        forwardUrls.push(fwdURL);
                        System.out.println(urls.peek());
                    } else {
                        System.out.println("no previous URLs");
                    }
                    break;

                case "forward":
                    isBack = true;
                    if (forwardUrls.isEmpty()) {
                        System.out.println("no next URLs");
                    } else {
                        String backUrl = forwardUrls.pop();
                        urls.push(backUrl);
                        System.out.println(backUrl);
                    }
                    break;
            }
            if(!isBack){
                urls.push(command);
                System.out.println(command);

                if(!forwardUrls.isEmpty()){
                    forwardUrls.clear();
                }
            }

            command = scanner.nextLine();
        }


    }
}
