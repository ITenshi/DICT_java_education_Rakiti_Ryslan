// hangman.java

import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        // Список слів
        String[] words = {"python", "java", "javascript", "kotlin"};

        // Випадковий вибір слова
        Random random = new Random();
        String targetWord = words[random.nextInt(words.length)];

        // Підказка для гравця
        StringBuilder hint = new StringBuilder(targetWord.substring(0, 2));
        for (int i = 2; i < targetWord.length(); i++) {
            hint.append("-");
        }

        System.out.println("Guess the word " + hint + ": ");

        // Отримання введення від користувача
        Scanner scanner = new Scanner(System.in);
        String userGuess = scanner.nextLine();

        // Перевірка введеного слова
        if (userGuess.equalsIgnoreCase(targetWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
