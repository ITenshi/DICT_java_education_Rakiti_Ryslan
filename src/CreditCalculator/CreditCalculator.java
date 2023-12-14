// src/CreditCalculator/CreditCalculator.java

package CreditCalculator;
import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("Type \"n\" for the number of monthly payments,");
        System.out.println("Type \"a\" for annuity monthly payment amount,");
        System.out.println("Type \"p\" for loan principal:");
        String calculationType = scanner.next();

        CalculatorLogic calculatorLogic = new CalculatorLogic();

        // Перевірка чи користувач використовує командний рядок
        if (args.length > 0) {
            String type = System.getProperty("type");
            String principal = System.getProperty("principal"); // P
            String periods = System.getProperty("periods"); // n
            String interest = System.getProperty("interest"); // for i calc
            String payment = System.getProperty("payment"); // A
            calculatorLogic.dataAnalyze(type, principal, periods, interest, payment);
        } else {
            // Запитати користувача ввести значення
            if ("n".equalsIgnoreCase(calculationType)) {
                // реалізуйте введення для кількості щомісячних платежів
            } else if ("a".equalsIgnoreCase(calculationType)) {
                // реалізуйте введення для щомісячного платежу
            } else if ("p".equalsIgnoreCase(calculationType)) {
                // реалізуйте введення для основної суми кредиту
            } else {
                System.out.println("Invalid calculation type. Please type \"n\", \"a\", or \"p\".");
            }
        }

        scanner.close();
    }
}
