package ee.bcs.java.demo.tasks.lesson1.solution;

import java.util.HashMap;
import java.util.Scanner;

public class Lesson4Solution {
    // Store account nr as a key and account balance as value
    static HashMap<String, Double> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Sisesta käsklus");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")){
                break;
            } else if(line.equalsIgnoreCase("createAccount")){
                // TODO 1
                // Add command: "createAccount ${accountNr}"
                // this has to store accountNr with 0 balance
                System.out.println("Palun sisesta konto number");
                String accountNumber = scanner.nextLine();
                accountBalanceMap.put(accountNumber, 0.0);
            } else if(line.equalsIgnoreCase("getBalance")){
                // TODO 2
                // Add command: "getBalance ${accountNr}"
                // this has to display account balance of specific acount
                System.out.println("Palun sisesta konto number");
                String accountNumber = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNumber);
                System.out.println("Konto jääk on: " + balance);
            } else if(line.equalsIgnoreCase("depositMoney")) {
                // TODO 3
                // Add command: "depositMoney ${accountNr} ${amount}
                // this has to add specified amount of money to account
                // You have to check that amount is positive number
                System.out.println("Palun sisesta konto number");
                String accountNumber = scanner.nextLine();
                System.out.println("Palun sisesta juurde pandud raha summa");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNumber) + amount;
                accountBalanceMap.put(accountNumber, balance);
            } else if(line.equalsIgnoreCase("withdrawMoney")){
                // TODO 4
                // Add command: "withdrawMoney ${accountNr} ${amount}
                // This has to remove specified amount of money from account
                // You have to check that amount is positive number
                // You may not allow this transaction if account balance would become negative
                System.out.println("Palun sisesta konto number");
                String accountNumber = scanner.nextLine();
                System.out.println("Palun sisesta maha võetud raha summa");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if(accountBalanceMap.get(accountNumber) - amount < 0){
                    System.out.println("Kontol pole piisavalt vahendeid");
                } else {
                    Double balance = accountBalanceMap.get(accountNumber) - amount;
                    accountBalanceMap.put(accountNumber, balance);
                }
            }
            else if(line.equalsIgnoreCase("transfer")){
                // TODO 5
                // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
                // This has to remove specified amount from fromAccount and add it to toAccount
                // Your application needs to check that toAccount is positive
                // And from account has enough money to do that transaction
                System.out.println("Sisesta konto millelt raha kanda");
                String fromAccount = scanner.nextLine();
                System.out.println("Sisesta konto millele raha kanda");
                String toAccount = scanner.nextLine();
                System.out.println("Sisesta summa mida kanda");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if(accountBalanceMap.get(fromAccount) - amount < 0){
                    System.out.println("kontol pole piisavalt raha");
                } else {
                    Double fromBalance = accountBalanceMap.get(fromAccount) - amount;
                    Double toBalance = accountBalanceMap.get(toAccount) + amount;
                    accountBalanceMap.put(fromAccount, fromBalance);
                    accountBalanceMap.put(toAccount, toBalance);
                }
            }
            else {
                System.out.println("Unknown command");
                System.out.println("Lubatud käsud on: exit, createAccount, getBalance, depositMoney, withdrawMoney, transfer");
            }
        }
    }
}
