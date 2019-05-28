package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branches> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branches>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branches(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branches branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branches branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branches findBranch(String branchName) {
        for (int i=0; i<this.branches.size(); i++) {
            if (this.branches.get(i).getName().equals(branchName)) {
                return this.branches.get(i);
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branches branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customers> branchCustomers = branch.getCustomers();

            for (int i=0; i<branchCustomers.size(); i++) {
                Customers branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + " [" + (i+1) + "]");

                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactios = branchCustomer.getTransactions();

                    for (int j=0; j<transactios.size(); j++) {
                        System.out.println(" [" + (j+1) + "] Amount " + transactios.get(j));
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

}
