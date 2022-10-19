package L03_SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P09_UserLogs1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
        String input = scanner.nextLine();
        //"IP={IP.Address} message={A&sample&message} user={username}"
        while(!input.equals("end")) {
            String[] inputParts = input.split("\\s+"); //["IP={IP.Address}", "message={A&sample&message}", "user={username}"]
            String ip = inputParts[0].split("=")[1]; //"IP={IP.Address}".split("=") -> ["IP","{ip addres}"]
            //String message = inputParts[1].split("=")[1]; // "message={A&sample&message}".split("=") -> ["message", "{A&sample&message}"]
            String username = inputParts[2].split("=")[1]; //"user={username}".split("=") -> ["user", "{username}"]

            //username да не съществува
            if (!data.containsKey(username)) {
                data.put(username, new LinkedHashMap<>(){
                    {
                        put(ip, 1);
                    }
                });
            }else {
                //текущия списък с ip
                Map<String, Integer> currentIps = data.get(username); //списък с ip-та (ip -> бр срещанията)
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

            input = scanner.nextLine();
        }

        data.entrySet().forEach(username -> {
            System.out.printf("%s: %n", username.getKey());

            Map<String, Integer> currentMap = new LinkedHashMap<>(username.getValue());
            int count =currentMap.size();
            for (Map.Entry<String, Integer> entry : currentMap.entrySet()) {
                if (count==1) {
                    System.out.printf("%s => %d.%n", entry.getKey(), entry.getValue());
                }else {
                    System.out.printf("%s => %d, ", entry.getKey(), entry.getValue());
                    count --;

                }

            }


        });
    }
}
