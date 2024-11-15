package entities;

import exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, double balance, Double withdrawal) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawal;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws DomainException {
        if(amount > this.balance) {
            throw new DomainException("Not enough balance");
        }
        if(amount > this.withdrawLimit) {
            throw new DomainException("The amount exceeds withdraw limit");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "New balance: " + this.balance;
    }


}
