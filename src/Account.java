import java.util.Scanner;

// Account class (base class)
class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs:" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {

            System.out.println("Withdrawn: Rs:" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayBalance() {
        System.out.println("Balance: Rs:" + balance);
    }
}

// SavingsAccount class (subclass of Account)
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest applied: Rs:" + interest);
    }
}

// ATM class
 class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount("123456", 1000.0, 0.05);

        // Display menu
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Apply Interest (Savings Account)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs:");
                    double depositAmount = scanner.nextDouble();
                    savingsAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: Rs:");
                    double withdrawAmount = scanner.nextDouble();
                    savingsAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    savingsAccount.displayBalance();
                    break;
                case 4:
                    if (savingsAccount instanceof SavingsAccount) {
                        ((SavingsAccount) savingsAccount).applyInterest();
                    } else {
                        System.out.println("Interest can only be applied to Savings Accounts.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting ATM. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

