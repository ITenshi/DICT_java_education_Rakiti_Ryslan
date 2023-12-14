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

        double loanPrincipal = 0;
        double monthlyPayment = 0;
        int numberOfMonths = 0;
        double loanInterest = 0;

        // Запитати користувача ввести значення
        if ("n".equalsIgnoreCase(calculationType)) {
            System.out.println("Enter the loan principal:");
            loanPrincipal = scanner.nextDouble();
            System.out.println("Enter the monthly payment:");
            monthlyPayment = scanner.nextDouble();

            // Розрахунок кількості місяців
            loanInterest /= 12 * 100; // перевести відсотки в десятковий формат
            double i = loanInterest / 12;
            numberOfMonths = (int) Math.ceil(Math.log(monthlyPayment / (monthlyPayment - i * loanPrincipal)) / Math.log(1 + i));
        } else if ("a".equalsIgnoreCase(calculationType)) {
            System.out.println("Enter the loan principal:");
            loanPrincipal = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            numberOfMonths = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            loanInterest = scanner.nextDouble();

            // Розрахунок щомісячного платежу
            loanInterest /= 12 * 100; // перевести відсотки в десятковий формат
            double i = loanInterest / 12;
            monthlyPayment = loanPrincipal * (i * Math.pow(1 + i, numberOfMonths)) / (Math.pow(1 + i, numberOfMonths) - 1);
        } else if ("p".equalsIgnoreCase(calculationType)) {
            System.out.println("Enter the annuity payment:");
            monthlyPayment = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            numberOfMonths = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            loanInterest = scanner.nextDouble();

            // Розрахунок основної суми кредиту
            loanInterest /= 12 * 100; // перевести відсотки в десятковий формат
            double i = loanInterest / 12;
            loanPrincipal = monthlyPayment / ((i * Math.pow(1 + i, numberOfMonths)) / (Math.pow(1 + i, numberOfMonths) - 1));
        } else {
            System.out.println("Invalid calculation type. Please type \"n\", \"a\", or \"p\".");
        }

        // Перевірка на введені некоректні значення
        if (loanPrincipal < 0 || monthlyPayment < 0 || numberOfMonths < 0 || loanInterest < 0) {
            System.out.println("Please enter valid positive values.");
        } else {
            // Результат
            int years = numberOfMonths / 12;
            int months = numberOfMonths % 12;

            System.out.print("Your ");
            if ("n".equalsIgnoreCase(calculationType)) {
                System.out.println("loan term is " + years + " years and " + months + " months!");
            } else if ("a".equalsIgnoreCase(calculationType)) {
                System.out.println("monthly payment = " + (int) Math.ceil(monthlyPayment) + "!");
            } else if ("p".equalsIgnoreCase(calculationType)) {
                System.out.println("loan principal = " + (int) Math.ceil(loanPrincipal) + "!");
            }
        }

        scanner.close();
    }
}
