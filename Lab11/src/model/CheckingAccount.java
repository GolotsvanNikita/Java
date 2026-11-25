package model;

import exceptions.DailyLimitExceededException;
import exceptions.InvalidAmountException;

public class CheckingAccount extends BankAccount
{
    private double dailyWithdrawalLimit = 300.0;

    public CheckingAccount(String customerName, String userId, String password)
    {
        super(customerName, userId, password);
    }

    public CheckingAccount(String customerName, String userId, String password, double dailyWithdrawalLimit)
    {
        super(customerName, userId, password);
        setDailyWithdrawalLimit(dailyWithdrawalLimit);
    }

    public double getDailyWithdrawalLimit()
    {
        return dailyWithdrawalLimit;
    }

    public void setDailyWithdrawalLimit(double dailyWithdrawalLimit)
    {
        if (dailyWithdrawalLimit <= 0)
        {
            throw new InvalidAmountException("Daily withdrawal limit must be greater than 0.");
        }
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }

    @Override
    public void withdraw(double amount)
    {
        if (amount <= 0)
        {
            throw new InvalidAmountException("Withdrawal amount must be greater than 0.");
        }
        if (amount > dailyWithdrawalLimit)
        {
            throw new DailyLimitExceededException(
                    "Withdrawal amount exceeds daily limit of " + dailyWithdrawalLimit
            );
        }
        super.withdraw(amount);
    }
}