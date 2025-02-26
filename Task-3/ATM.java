import java.util.Scanner;

public class ATM {

    private BankAccount account;

    public ATM(BankAccount bankAccount) {
        account = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.printf("Your balance: Rs. %.2f%n", account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            System.out.printf("Deposit successful. Your balance: Rs. %.2f%n", account.getBalance());
                        } else {
                            System.out.println("Invalid amount. Please enter a valid number.");
                            scanner.next(); // Clear invalid input
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        if (scanner.hasNextDouble()) {
                            double withdrawAmount = scanner.nextDouble();
                            if (account.withdraw(withdrawAmount)) {
                                System.out.printf("Withdrawal successful. Your balance: Rs. %.2f%n",
                                        account.getBalance());
                            }
                        } else {
                            System.out.println("Invalid amount. Please enter a valid number.");
                            scanner.next(); // Clear invalid input
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please select a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}