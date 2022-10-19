package L03_SetsAndMapsAdvanced.Labs;

import java.util.*;

public class P05_AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String , List<Double>> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String input = scanner.nextLine();

            String currentStudent = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);
            List<Double> currentGrade = new ArrayList<>();
            if (!students.containsKey(currentStudent)){
                currentGrade.add(grade);
                students.put(currentStudent, currentGrade);

            }else {
                currentGrade = students.get(currentStudent);
                currentGrade.add(grade);
            }

        }

        students.entrySet().stream()
                .forEach(entry -> {
                    System.out.printf(entry.getKey() + " -> ");
                    //entry.getValue().stream().forEach(grade -> System.out.print(grade + " "));
                    double average = 0;
                    int count = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        count++;
                        System.out.printf("%.2f ", entry.getValue().get(i));
                        average+= entry.getValue().get(i);

                    }
                    average = average / count;
                    System.out.printf("(avg: %.2f)%n", average);

                });




    }
}
