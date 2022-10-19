package L05_FunctionalProgramming.Labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        int firstNum = Integer.parseInt(data[0]);
        int secondNum = Integer.parseInt(data[1]);

        List<Integer> numbers = new ArrayList<>();

        if (secondNum > firstNum) {
            for (int i = firstNum; i <=secondNum ; i++) {
                numbers.add(i);

            }
        }else {
            for (int i = firstNum; i >= secondNum ; i--) {
                numbers.add(i);

            }
        }
        String command = scanner.nextLine();

        Predicate<Integer> filterPredicate;
        Consumer<Integer> printConsumer = number -> System.out.printf("%d ", number);

        if (command.equals("odd")){
            filterPredicate = number -> number % 2 == 1 || number % 2 == -1;
        }else {
            filterPredicate = number -> number % 2 == 0;
        }
        numbers.stream().filter(filterPredicate).forEach(printConsumer);
        System.out.println();

    }
}
