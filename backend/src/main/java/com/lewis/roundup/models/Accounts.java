package com.lewis.roundup.models;

import java.io.Serializable;
import java.util.List;

public class Accounts implements Serializable {

    private List<Account> accounts;

    public Accounts() {
    }

    // We don't care about other accounts for now, but this could be expanded if the customer has multiple accounts
    public Account getFirst() {
        return accounts.get(0);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accounts=" + accounts +
                '}';
    }
}
