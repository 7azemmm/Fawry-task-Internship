package org.example;

import java.util.List;

public class Customer {
    protected String name;
    protected int age;
    protected String address;
    protected double balance;


    public Customer() {
    }

    public Customer(String name, int age, String address, double balance) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.balance = balance;
    }

}
