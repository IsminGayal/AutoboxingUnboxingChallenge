package com.company;

import java.util.ArrayList;

public class Customers {
    private ArrayList<Double> transactions;
    private String name;

    public Customers(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransactions(initialAmount);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }

    public void addTransactions(double amount) {
        this.transactions.add(amount);
    }

}
