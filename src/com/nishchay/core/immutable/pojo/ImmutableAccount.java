package com.nishchay.core.immutable.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class ImmutableAccount {

    private final Long accountNumber;
    private final List<Transactions> transactions;
    private final Address currentAddress;

    public ImmutableAccount(Long accountNumber,
                            List<Transactions> transactions,
                            Address currentAddress) {

        this.accountNumber = Objects.requireNonNull(accountNumber);

        List<Transactions> copy = new ArrayList<>();
        for (Transactions t : transactions) {
            copy.add(new Transactions(t));  // copy constructor
        }
        this.transactions = Collections.unmodifiableList(copy);

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



