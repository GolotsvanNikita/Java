import exceptions.*;
import model.BankAccount;
import model.CheckingAccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientInterface
{

    private final List<BankAccount> accounts = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    private final List<String> options = List.of(
            "1 - Create account",
            "2 - Delete account",
            "3 - Make account deposit",
            "4 - Make account withdrawal",
            "5 - Print account info",
            "6 - Exit"
    );

    public void start() throws IOException
    {
        String option;
        while (true)
        {
            printMainMenu();
            option = scanner.next();

            int choice;
            try
            {
                choice = Integer.parseInt(option);
            }
            catch (NumberFormatException e)
            {
                System.err.println("Error: Please enter a valid choice (1 thru 6)\n");
                continue;
            }

            try
            {
                switch (choice)
                {
                    case 1:
                        addNewAccount();
                        break;
                    case 2:
                        deleteAccount();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        withdraw();
                        break;
                    case 5:
                        printInfo();
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.err.println("Error: Please enter a valid choice (1 thru 6)\n");
                }
            }
            catch (AccountException e)
            {
                System.err.println("Error: " + e.getMessage() + "\n");
            }
        }
    }

    private void printMainMenu()
    {
        System.out.println("\n****************");
        System.out.println("Banking system: ");
        System.out.println("****************");
        options.forEach(System.out::println);
        System.out.print("\n>>> Choose your option: ");
    }

    private BankAccount authenticate(String userId, String password)
    {
        BankAccount account = accounts.stream()
                .filter(acc -> acc.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Account with userId '" + userId + "' not found."));

        if (!account.checkPassword(password))
        {
            throw new InvalidPasswordException("Incorrect password.");
        }
        return account;
    }

    private double parseAmount(String amountStr)
    {
        try
        {
            return Double.parseDouble(amountStr);
        }
        catch (NumberFormatException e)
        {
            throw new InvalidAmountException("Invalid amount format: '" + amountStr + "'.");
        }
    }

    private void addNewAccount()
    {
        System.out.println("\n****************");
        System.out.println("Creating new account: ");
        System.out.println("****************");

        System.out.print(">>> Enter customer name: ");
        var name = scanner.next();
        System.out.print(">>> Enter user id: ");
        var userId = scanner.next();
        System.out.print(">>> Enter user password: ");
        String password = scanner.next();
        System.out.print(">>> Confirm password: ");
        String confirmPassword = scanner.next();

        boolean exists = accounts.stream().anyMatch(acc -> acc.getUserId().equals(userId));
        if (exists)
        {
            throw new AccountAlreadyExistsException("Account with userId '" + userId + "' already exists.");
        }

        if (!password.equals(confirmPassword))
        {
            throw new InvalidPasswordException("Password and confirmation password do not match.");
        }

        CheckingAccount newAccount = new CheckingAccount(name, userId, password);
        accounts.add(newAccount);
        System.out.println("Account successfully created!");
    }

    private void deleteAccount()
    {
        System.out.println("\n****************");
        System.out.println("Deleting account: ");
        System.out.println("****************");

        System.out.print(">>> Enter user id: ");
        var userId = scanner.next();
        System.out.print(">>> Enter user password: ");
        var password = scanner.next();

        BankAccount account = authenticate(userId, password);
        if (account.getBalance() != 0)
        {
            throw new NonZeroBalanceException(
                    "Cannot delete account with non-zero balance (" + account.getBalance() + ")."
            );
        }

        accounts.remove(account);
        System.out.println("Account successfully deleted!");
    }

    private void deposit()
    {
        System.out.println("\n****************");
        System.out.println("Making a deposit: ");
        System.out.println("****************");

        System.out.print(">>> Enter user id: ");
        var userId = scanner.next();
        System.out.print(">>> Enter user password: ");
        var password = scanner.next();
        System.out.print(">>> Enter amount: ");
        var amountStr = scanner.next();

        BankAccount account = authenticate(userId, password);
        double amount = parseAmount(amountStr);
        account.deposit(amount);
        System.out.println("Deposit successful! New balance: " + account.getBalance());
    }

    private void withdraw()
    {
        System.out.println("\n****************");
        System.out.println("Making a withdrawal: ");
        System.out.println("****************");

        System.out.print(">>> Enter user id: ");
        var userId = scanner.next();
        System.out.print(">>> Enter user password: ");
        var password = scanner.next();
        System.out.print(">>> Enter amount: ");
        var amountStr = scanner.next();

        BankAccount account = authenticate(userId, password);
        double amount = parseAmount(amountStr);
        account.withdraw(amount);
        System.out.println("Withdrawal successful! New balance: " + account.getBalance());
    }

    private void printInfo()
    {
        System.out.println("\n****************");
        System.out.println("Printing account info: ");
        System.out.println("****************");

        System.out.print(">>> Enter user id: ");
        var userId = scanner.next();
        System.out.print(">>> Enter user password: ");
        var password = scanner.next();

        BankAccount account = authenticate(userId, password);

        System.out.println("\nAccount info: ");
        System.out.println(" - customer name: " + account.getCustomerName());
        System.out.println(" - account balance: " + account.getBalance());
        if (account instanceof CheckingAccount checkingAccount)
        {
            System.out.println(" - account type: Checking");
            System.out.println(" - account daily withdrawal limit: " + checkingAccount.getDailyWithdrawalLimit());
        }
        else
        {
            System.out.println(" - account type: Standard");
        }

        System.out.print("\nPress Enter to return to main menu...");

        try
        {
            System.in.read();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}