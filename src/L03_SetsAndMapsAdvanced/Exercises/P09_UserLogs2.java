package L03_SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09_UserLogs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "IP=(?<IP>[A-z0-9\\.?:?]+).+user=(?<username>[A-z0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        while (!input.equals("end")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String IP = matcher.group("IP");
                String username = matcher.group("username");

                fillMap(IP, username, logs);

            }


            input = scanner.nextLine();
        }


        logs.entrySet().forEach(username -> {
            System.out.printf("%s: %n", username.getKey());

            Map<String, Integer> currentMap = new LinkedHashMap<>(username.getValue());
            int count = currentMap.size();
            for (Map.Entry<String, Integer> entry : currentMap.entrySet()) {
                if (count == 1) {
                    System.out.printf("%s => %d.%n", entry.getKey(), entry.getValue());
                } else {
                    System.out.printf("%s => %d, ", entry.getKey(), entry.getValue());
                    count--;

                }

            }


        });
    }

    private static void fillMap(String ip, String username, TreeMap<String, LinkedHashMap<String, Integer>> logs) {

        if (!logs.containsKey(username)) {
            logs.put(username, new LinkedHashMap<>() {
                {
                    put(ip, 1);
                }
            });
        } else {
            //текущия списък с ip
            Map<String, Integer> currentIps = logs.get(username); //списък с ip-та (ip -> бр срещанията)
            //ip да е посетено (има в списъка)
            if (currentIps.containsKey(ip)) {
                int currentTimes = currentIps.get(ip);
                currentIps.put(ip, currentTimes + 1);
            }
            //ip не е посещавано (няма в списъка)
            else {
                currentIps.put(ip, 1);
            }
        }
    }
}
