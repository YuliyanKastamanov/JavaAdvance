package L03_SetsAndMapsAdvanced.Labs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(
                        //(n1, n2) -> n1.compareTo(n2)
                        Comparator.reverseOrder()
                ).limit(3)
                .forEach(number -> System.out.printf("%d ", number));
    }
}
