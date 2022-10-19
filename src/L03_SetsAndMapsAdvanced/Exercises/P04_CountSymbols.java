package L03_SetsAndMapsAdvanced.Exercises;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<Character, Integer> result = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (!result.containsKey(currentChar)){
                result.put(currentChar, 1);

            }else {
                int currentCount = result.get(currentChar);
                currentCount++;
                result.put(currentChar, currentCount);
            }



        }

        result.entrySet().stream().forEach(e -> System.out.printf("%c: %d time/s%n",e.getKey(), e.getValue() ));
    }
}
