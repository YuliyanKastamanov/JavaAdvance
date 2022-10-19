package L05_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P02_KnightsOfHonor1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> consumerPrint = e -> System.out.println("Sir " + e);
        names.forEach(consumerPrint);
    }
}
