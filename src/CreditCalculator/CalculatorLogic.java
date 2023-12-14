// src/CreditCalculator/CalculatorLogic.java

package CreditCalculator;

public class CalculatorLogic {

    public void dataAnalyze(String type, String principal, String periods, String interest, String payment) {
        double loanPrincipal = 0;
        int numberOfMonths = 0;
        double loanInterest = 0;
        double monthlyPayment = 0;

        try {
            // Перевірка на наявність необхідних параметрів
            if (type == null || principal == null || periods == null || interest == null) {
                throw new IllegalArgumentException("Incorrect parameters");
            }

            // Конвертація параметрів
            loanPrincipal = Double.parseDouble(principal);
            numberOfMonths = Integer.parseInt(periods);
            loanInterest = Double.parseDouble(interest);

            // Розрахунок відсоткової ставки та щомісячного платежу для щорічного платежу
            if ("annuity".equalsIgnoreCase(type)) {
                double i = loanInterest / 12 / 100;
                monthlyPayment = loanPrincipal * (i * Math.pow(1 + i, numberOfMonths))
                        / (Math.pow(1 + i, numberOfMonths) - 1);
                System.out.println("Your annuity payment = " + (int) Math.ceil(monthlyPayment) + "!");
            }
            // Розрахунок диференційованих платежів
            else if ("diff".equalsIgnoreCase(type)) {
                double totalPayments = 0;
                for (int month = 1; month <= numberOfMonths; month++) {
                    double dm = loanPrincipal / numberOfMonths + loanInterest / 12 / 100
                            * (loanPrincipal - loanPrincipal * (month - 1) / numberOfMonths);
                    totalPayments += dm;
                    System.out.println("Month " + month + ": payment is " + (int) Math.ceil(dm));
                }
                System.out.println("Overpayment = " + (int) Math.ceil(totalPayments - loanPrincipal));
            } else {
                throw new IllegalArgumentException("Incorrect parameters");
            }

        } catch (NumberFormatException e) {
            System.out.println("Incorrect parameters");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
