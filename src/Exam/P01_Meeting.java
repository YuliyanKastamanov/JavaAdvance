package Exam;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();

        for (String male: firstLine) {

            malesStack.push(Integer.parseInt(male));

        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        for (String female: secondLine) {

            femalesQueue.offer(Integer.parseInt(female));

        }

        int matches = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()){
            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male <= 0){
                malesStack.pop();
                continue;
            }else if (female <= 0){
                femalesQueue.remove();
                continue;
            }
            if (male % 25 == 0){
                malesStack.pop();
                malesStack.pop();
                continue;
            }else if (female % 25 == 0){
                femalesQueue.remove();
                femalesQueue.remove();
                continue;
            }
            if (male == female){
                malesStack.pop();
                femalesQueue.remove();
                matches++;
            }else {
                femalesQueue.remove();
                malesStack.pop();
                malesStack.push(male - 2);
            }


        }

        System.out.println("Matches: " + matches);
        if(malesStack.isEmpty()){
            System.out.println("Males left: none");
        }else {
            System.out.printf("Males left: ");
            System.out.println(String.join(", ", malesStack.toString()).replaceAll("[\\[\\]]", ""));

            }
        if(femalesQueue.isEmpty()){
            System.out.println("Females left: none");
        }else {
            System.out.print("Females left: ");
            System.out.println(String.join(", ", femalesQueue.toString()).replaceAll("[\\[\\]]", ""));

        }

        }
    }

