/*
 *
 *  * Copyright (c) 2022.
 *  * Vahid Alizadeh
 *  * Object-oriented Software Development
 *  * DePaul University
 *
 */

package DesignPatterns.ChainOfResponsibility.ATMExample;

import java.util.Scanner;

public class ATMDispenseClient {
    private int[] Currency = {50,20,10};

    private DispenseChain c1;

    public ATMDispenseClient() {
        this.c1 = new DollarDispenser(50);
        DispenseChain c2 = new DollarDispenser(20);
        DispenseChain c3 = new DollarDispenser(10);


        // // initialize the chain
        // this.c1 = new Dollar50Dispenser();
        // DispenseChain c2 = new Dollar20Dispenser();
        // DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }



    public static void main(String[] args) {
        ATMDispenseClient atmDispenser = new ATMDispenseClient();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }

    }

}
