package model;

public class Expense {
    private final String name;
    private final double amount;

    public Expense(String name, double amount) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Expense name cannot be empty.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        this.name = name.trim();
        this.amount = amount;
    }

    public String getName() { return name; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", amount);
    }
}
