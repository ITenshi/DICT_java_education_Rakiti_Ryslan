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

        System.out.println("Guess the word: ");

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
