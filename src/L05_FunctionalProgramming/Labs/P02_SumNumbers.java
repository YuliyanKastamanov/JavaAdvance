package L05_FunctionalProgramming.Labs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> numbers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());


        int sum = numbers.stream().mapToInt(Integer::parseInt).sum();

        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);

    }
}
