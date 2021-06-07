package com.geektech;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        BankAccount bankAccount = new BankAccount();
        System.out.println("На ваш баланс добавлен " + bankAccount.deposit(20000) + " cом");

        while (true)
            try {
                bankAccount.withDraw(6000);
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                System.out.println("У вас на счету: " + bankAccount.getAmount() + " сом");
                System.out.println("Хотите снять остаток?");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                if (s.equals("да") || s.equals("ДА") || s.equals("Да")) {
                    try {
                        bankAccount.withDraw(bankAccount.getAmount());
                    } catch (LimitException e1) {
                        System.out.println(e1.getMessage());

                    }
                    break;

                } else System.out.println("Вы не сняли остаток");
                break;


            }
        System.out.println("На вашем счету: " + bankAccount.getAmount() + " сом");

    }
}