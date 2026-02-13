package com.nishchay.core.immutable.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ImmutableAccount {

    private final Long accountNumber;
    private final List<Transactions> transactions;
    private final Address currentAddress;

    public ImmutableAccount(Long accountNumber, List<Transactions> transactions, Address currentAddress) {

        this.accountNumber = Objects.requireNonNull(accountNumber);

        List<Transactions> copyList = new ArrayList<>();
        for (Transactions t : transactions) {
            copyList.add(new Transactions(t));
        }
        this.transactions = Collections.unmodifiableList(copyList); // getting a read-only view for this copyList
        this.currentAddress = new Address(currentAddress);
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public Address getCurrentAddress() {
        return new Address(currentAddress);
    }
}



