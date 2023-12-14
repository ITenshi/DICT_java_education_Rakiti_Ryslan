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

        // Стан слова, яке гравець повинен вгадати
        StringBuilder currentWordState = new StringBuilder();
        for (int i = 0; i < targetWord.length(); i++) {
            currentWordState.append("-");
        }

        // Кількість спроб
        int attemptsLeft = 8;

        // Гра
        while (attemptsLeft > 0) {
            System.out.println(currentWordState);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Input a letter: ");

            // Отримання введення від користувача
            Scanner scanner = new Scanner(System.in);
            String userLetter = scanner.nextLine();

            // Перевірка, чи введена літера з'являється в слові
            boolean letterGuessed = false;
            for (int i = 0; i < targetWord.length(); i++) {
                if (userLetter.equalsIgnoreCase(String.valueOf(targetWord.charAt(i)))) {
                    currentWordState.setCharAt(i, targetWord.charAt(i));
                    letterGuessed = true;
                }
            }

            // Зменшення кількості спроб, якщо літера не вгадана
            if (!letterGuessed) {
                attemptsLeft--;
                System.out.println("That letter doesn't appear in the word");
            }

            // Перевірка, чи слово повністю вгадано
            if (currentWordState.toString().equalsIgnoreCase(targetWord)) {
                System.out.println(currentWordState);
                System.out.println("You survived!");
                break;
            }
        }

        // Виведення результату гри
        if (attemptsLeft == 0) {
            System.out.println("Thanks for playing!");
            System.out.println("We'll see how well you did in the next stage");
        }
    }
}
