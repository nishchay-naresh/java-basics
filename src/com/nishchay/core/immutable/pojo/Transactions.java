package com.nishchay.core.immutable.pojo;

public class Transactions {

    private String transactionId;
    private double amount;

    public Transactions(){

    }
    public Transactions(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public Transactions(Transactions transaction) {
        this.transactionId = transaction.transactionId;
        this.amount = transaction.amount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                '}';
    }
}