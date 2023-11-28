import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Етап 1: Привітання та відображення імені та року створення
        String botName = "SimpleBot"; // Змінна для імені бота
        int birthYear = 2023; // Змінна для року створення бота

        // Виведення привітання у консоль
        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("ChatBot 1-st stage\n");

        // Етап 2: Представлення та привітання за ім'ям користувача
        Scanner scanner = new Scanner(System.in); // Об'єкт для зчитування введення з консолі

        // Запитання про ім'я користувача
        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine(); // Зчитування імені користувача з консолі

        // Привітання за ім'ям користувача
        System.out.println("What a great name you have, " + userName + "!");
        System.out.println("ChatBot 2-nd stage\n");

        // Етап 3: Вгадування віку користувача
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7.");

        // Зчитування залишків від ділення віку користувача на 3, 5, та 7
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        // Визначення віку за формулою
        int userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        // Виведення вгаданого віку
        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");
        System.out.println("ChatBot 3-rd stage\n");

        // Етап 4: Підрахунок до введеного користувачем числа
        System.out.println("Now I will prove to you that I can count to any number you want!");
        int userInp = scanner.nextInt(); // Зчитування числа від користувача

        // Підрахунок та виведення чисел до введеного користувачем числа
        for (int i = 1; i <= userInp; i++) {
            System.out.println(i + "!");
        }

        System.out.println("ChatBot 4-th stage\n");

        // Етап 5: Тест для користувача
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        int correctAnswer = 2; // Правильна відповідь

        // Перевірка відповіді користувача
        int userAnswer;
        do {
            System.out.println("Please, enter the number of your answer:");
            userAnswer = scanner.nextInt();

            if (userAnswer != correctAnswer) {
                System.out.println("Your answer is incorrect. Please, try again.");
            }
        } while (userAnswer != correctAnswer);

        // Виведення повідомлення про правильну відповідь
        System.out.println("Congratulations! That's correct.");
        System.out.println("Goodbye, have a nice day!");

        // Закриваємо Scanner для уникнення витоку ресурсів
        scanner.close();
    }
}
