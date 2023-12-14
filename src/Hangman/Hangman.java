// hangman.java

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("Guess the word: ");

        // Слово, яке гравець повинен вгадати
        String targetWord = "java";

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
