// src/CreditCalculator/CreditCalculator.java

package CreditCalculator;
import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Етап 1: Виведення текстових повідомлень
        double loanPrincipal = 0;
        while (loanPrincipal <= 0) {
            System.out.println("Enter the loan principal:");
            loanPrincipal = scanner.nextDouble();
            if (loanPrincipal <= 0) {
                System.out.println("Please enter a valid loan principal (greater than 0).");
            }
        }

        System.out.println("What do you want to calculate?");
        System.out.println("Type \"m\" – for the number of monthly payments,");
        System.out.println("Type \"p\" – for the monthly payment:");
        String calculationType = scanner.next();

        // Етап 2: Визначення варіанту розрахунку
        if ("m".equalsIgnoreCase(calculationType)) {
            // Розрахунок кількості місяців
            System.out.println("Enter the monthly payment:");
            double monthlyPayment = scanner.nextDouble();

            int monthsToRepay = (int) Math.ceil(loanPrincipal / monthlyPayment);
            System.out.println("It will take " + monthsToRepay + " months to repay the loan");
        } else if ("p".equalsIgnoreCase(calculationType)) {
            // Розрахунок розміру щомісячного платежу
            System.out.println("Enter the number of months:");
            int numberOfMonths = scanner.nextInt();

            double monthlyPayment = loanPrincipal / numberOfMonths;
            double lastPayment = loanPrincipal - (numberOfMonths - 1) * monthlyPayment;

            System.out.println("Your monthly payment = " + (int) Math.ceil(monthlyPayment));
            if (monthlyPayment != lastPayment) {
                System.out.println("and the last payment = " + (int) Math.ceil(lastPayment));
            }
        } else {
            System.out.println("Invalid calculation type. Please type \"m\" or \"p\".");
        }

        scanner.close();
    }
}
