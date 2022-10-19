package L03_SetsAndMapsAdvanced.Labs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        TreeMap<String, String> graduation = new TreeMap<>();



        for (int i = 0; i < input; i++) {
            String name = scanner.nextLine();
            String[] scoreString = scanner.nextLine().split("\\s+");
            Double[] score = new Double[scoreString.length];
            double scoreSum = 0;
            for (int j = 0; j < scoreString.length; j++) {
                score[j] = Double.parseDouble(scoreString[j]);
                scoreSum += score[j];


            }


            scoreSum = scoreSum / score.length;
            String scoreToAdd = scoreSum + "";
            graduation.put(name,scoreToAdd);

        }

        for (String name : graduation.keySet()) {

            System.out.printf("%s is graduated with %s%n", name, graduation.get(name));
        }
    }
}
