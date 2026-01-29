package model;

import java.util.ArrayList;
import java.util.List;

public class BudgetMonth {
    private final List<Expense> expenses = new ArrayList<>();

    // NEW: monthly income
    private double monthlyIncome = 0.0;

    public BudgetMonth() { }

    public void setMonthlyIncome(double monthlyIncome) {
        if (monthlyIncome < 0) {
            throw new IllegalArgumentException("Monthly income cannot be negative.");
        }
        this.monthlyIncome = monthlyIncome;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void addExpense(Expense e) {
        if (e == null) {
            throw new IllegalArgumentException("Expense cannot be null.");
        }
        expenses.add(e);
    }

    public double totalExpenses() {
        double sum = 0;
        for (Expense e : expenses) sum += e.getAmount();
        return sum;
    }

    public double remaining() {
        return monthlyIncome - totalExpenses();
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }
}
