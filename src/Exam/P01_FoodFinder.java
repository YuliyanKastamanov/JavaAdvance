package Exam;

import java.util.*;

public class P01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word1 = "pear";
        String word2 = "flour";
        String word3 = "pork";
        String word4 = "olive";
        List<String> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);

        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<String> vowelsQueue  = new ArrayDeque<>();

        for (String vowel: firstLine) {
            vowelsQueue.offer(vowel);

        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        for (String consonants: secondLine) {

            consonantsStack.push(consonants);

        }
        int countWords = 0;

        while (!consonantsStack.isEmpty()){
            String currentVowel = vowelsQueue.peek();
            String currentConsonant = consonantsStack.peek();

            if (word1.contains(currentVowel)){
                word1 = word1.replace(currentVowel, "");
            }
            if (word1.contains(currentConsonant)){
                word1 = word1.replace(currentConsonant, "");
            }

            if (word2.contains(currentVowel)){
                word2 = word2.replace(currentVowel, "");
            }
            if (word2.contains(currentConsonant)){
                word2 = word2.replace(currentConsonant, "");
            }
            if (word3.contains(currentVowel)){
                word3 = word3.replace(currentVowel, "");
            }
            if (word3.contains(currentConsonant)){
                word3 = word3.replace(currentConsonant, "");
            }
            if (word4.contains(currentVowel)){
                word4 = word4.replace(currentVowel, "");
            }
            if (word4.contains(currentConsonant)){
                word4 = word4.replace(currentConsonant, "");
            }

            vowelsQueue.poll();
            consonantsStack.pop();
            vowelsQueue.offer(currentVowel);

        }

        if (word1.equals("")){
            countWords++;
        }else {
            words.remove("pear");
        }
        if (word2.equals("")){
            countWords++;
        }else {
            words.remove("flour");
        }

        if (word3.equals("")){
            countWords++;
        }else {
            words.remove("pork");
        }
        if (word4.equals("")){
            countWords++;
        }else {
            words.remove("olive");
        }

        System.out.println("Words found: " + countWords);

        for (String word : words) {
            System.out.println(word);
        }

    }
}
