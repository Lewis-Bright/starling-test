package com.lewis.roundup.models;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {

    private final String accountUid;

    private final String accountType;

    private final String defaultCategory;

    private final String currency;

    private final Date createdAt;

    private final String name;

    public Account(String accountUid, String accountType, String defaultCategory, String currency, Date createdAt, String name) {
        this.accountUid = accountUid;
        this.accountType = accountType;
        this.defaultCategory = defaultCategory;
        this.currency = currency;
        this.createdAt = createdAt;
        this.name = name;
    }

    public String getAccountUid() {
        return accountUid;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getDefaultCategory() {
        return defaultCategory;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountUid='" + accountUid + '\'' +
                ", accountType='" + accountType + '\'' +
                ", defaultCategory='" + defaultCategory + '\'' +
                ", currency='" + currency + '\'' +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                '}';
    }
}
