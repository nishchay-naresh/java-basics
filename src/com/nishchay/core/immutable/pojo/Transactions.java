package com.nishchay.core.immutable.pojo;

public final class Transactions {

    private final String transactionId;
    private final double amount;

    public Transactions(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public Transactions(Transactions other) {
        this.transactionId = other.transactionId;
        this.amount = other.amount;
    }

    // no setters to protect the immutability
    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                '}';
    }
}