import java.util.*;

public class ATM {

    static double balance = 1000.0;
    static List<String> history = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int correctPin = 1234;
        int attempts = 0;

        System.out.println("===== Welcome to ATM =====");

        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == correctPin) {
                System.out.println("Login Successful!");
                menu(sc);
                return;
            } else {
                attempts++;
                System.out.println("Wrong PIN!");
            }
        }

        System.out.println("Card Blocked! Too many attempts.");
    }

    public static void menu(Scanner sc) {

        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    balance += deposit;
                    history.add("Deposited ₹" + deposit);
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        history.add("Withdrew ₹" + withdraw);
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 4:
                    System.out.println("Transaction History:");
                    for (String h : history) {
                        System.out.println(h);
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}