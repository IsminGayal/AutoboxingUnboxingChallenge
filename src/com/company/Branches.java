package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Branches {
    public static Scanner scanner = new Scanner(System.in);
    private ArrayList<Customers> customers;
    private String name;

    public Branches(String name) {
        this.name = name;
        this.customers = new ArrayList<Customers>();
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customers(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customers existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransactions(amount);
            return true;
        }
        return false;
    }

    private Customers findCustomer(String customerName) {
        for (int i=0; i<this.customers.size(); i++) {
            if (this.customers.get(i).getName().equals(customerName)) {
                return this.customers.get(i);
            }
        }
        return null;
    }


}
