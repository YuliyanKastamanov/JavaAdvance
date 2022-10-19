package L03_SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06_MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String resource = scanner.nextLine();
        int quantity = 0;

        LinkedHashMap<String, Integer> mine = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            quantity = Integer.parseInt(scanner.nextLine());

            if (!mine.containsKey(resource)) {
                mine.put(resource, quantity);
            } else {
                quantity += mine.get(resource);
                mine.put(resource, quantity);
            }


            resource = scanner.nextLine();
        }
        mine.entrySet().stream().forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
    }
}
