package model;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import exceptions.InvalidPasswordException;

public class BankAccount
{
    private String customerName;
    private String userId;
    private String password;
    private double balance;

    public BankAccount(String customerName, String userId, String password)
    {
        validatePassword(password);
        this.customerName = customerName;
        this.userId = userId;
        this.password = password;
        this.balance = 0.0;
    }

    public static void validatePassword(String password)
    {
        if (password == null || password.length() < 8)
        {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }
        boolean hasDigit = false;
        for (char c : password.toCharArray())
        {
            if (Character.isDigit(c))
            {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit)
        {
            throw new InvalidPasswordException("Password must contain at least one digit.");
        }
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        validatePassword(password);
        this.password = password;
    }

    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        if (balance < 0)
        {
            throw new InvalidAmountException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
        {
            throw new InvalidAmountException("Deposit amount must be greater than 0.");
        }
        balance += amount;
    }

    public void withdraw(double amount)
    {
        if (amount <= 0)
        {
            throw new InvalidAmountException("Withdrawal amount must be greater than 0.");
        }
        if (amount > balance)
        {
            throw new InsufficientFundsException("Insufficient funds. Current balance: " + balance);
        }
        balance -= amount;
    }
}