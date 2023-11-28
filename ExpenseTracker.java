import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;
    String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}

class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private Scanner scanner;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addExpense() {
        System.out.println("Enter expense details:");
        System.out.print("Description: ");
        String description = scanner.nextLine();

        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            try {
                System.out.print("Amount: $");
                amount = Double.parseDouble(scanner.nextLine());
                validAmount = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }

        System.out.print("Category: ");
        String category = scanner.nextLine();

        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);

        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        System.out.println("Expense List:");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.description);
            System.out.println("Amount: $" + expense.amount);
            System.out.println("Category: " + expense.category);
            System.out.println("------------------------");
        }
    }

    public void expenseSummaries() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        // Implement summaries based on your requirements (e.g., total expenses for a specific category, time period).
        // You can add more functionality here based on your project requirements.
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        int choice;

        do {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Expense Summaries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(expenseTracker.scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    expenseTracker.addExpense();
                    break;
                case 2:
                    expenseTracker.viewExpenses();
                    break;
                case 3:
                    expenseTracker.expenseSummaries();
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (choice != 4);
    }
}
