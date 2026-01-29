package ui;

import java.util.Scanner;
import model.BudgetMonth;
import model.Expense;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BudgetMonth budget = new BudgetMonth();

        System.out.println("Budget Buddy Console");

        // NEW: ask for monthly income first
        double income = readDouble(sc, "Enter your total monthly income: ");
        budget.setMonthlyIncome(income);

        System.out.println("\nEnter your monthly expenses.");
        System.out.println("Type 'done' to finish.\n");

        while (true) {
            System.out.print("Expense name: ");
            String name = sc.nextLine().trim();
            if (name.equalsIgnoreCase("done")) break;

            double amt = readDouble(sc, "Amount: ");

            try {
                budget.addExpense(new Expense(name, amt));
                System.out.println("Added.\n");
            } catch (Exception ex) {
                System.out.println("Invalid entry. Try again.\n");
            }
        }

        // Summary
        System.out.println("\n--- Summary ---");
        System.out.println("Income:   $" + String.format("%.2f", budget.getMonthlyIncome()));
        System.out.println("Expenses: $" + String.format("%.2f", budget.totalExpenses()));
        System.out.println("Remaining:$" + String.format("%.2f", budget.remaining()));

        System.out.println("\nExpenses list:");
        for (Expense e : budget.getExpenses()) {
            System.out.println(" - " + e);
        }

        sc.close();
    }

    // Helper: repeatedly ask until user enters a valid number
    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < 0) {
                    System.out.println("Please enter a value >= 0.\n");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.\n");
            }
        }
    }
}
