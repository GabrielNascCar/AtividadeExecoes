package org.example;

import entities.Account;
import exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        String holder = sc.next();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, initialBalance, withdrawLimit);

        try {
            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double withdrawAmount = sc.nextDouble();

            account.withdraw(withdrawAmount);
            System.out.println(account);
        }catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }
}