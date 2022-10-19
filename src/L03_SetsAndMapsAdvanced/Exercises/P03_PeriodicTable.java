package L03_SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements =  new TreeSet<>();

        for (int i = 0; i < number; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            Arrays.stream(line).forEach(e -> elements.add(e));

        }

        elements.stream().forEach(e -> System.out.printf("%s ", e));

    }
}
