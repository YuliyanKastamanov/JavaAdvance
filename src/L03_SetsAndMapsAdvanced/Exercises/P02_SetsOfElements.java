package L03_SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int firstNum = Integer.parseInt(data[0]);
        int secondNum = Integer.parseInt(data[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstNum; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentNum);
        }
        for (int i = 0; i < secondNum; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentNum);
        }

        Set<Integer> duplicateElements = new LinkedHashSet<>(); //съхраняваме поватарящите се елементи от двата сета
        for (int number : firstSet) {
            if (secondSet.contains(number)) {
                duplicateElements.add(number);
            }
        }
        //всички елементи, които ги има и в двата сета
        duplicateElements.forEach(el -> System.out.print(el + " "));
        
    }
}
