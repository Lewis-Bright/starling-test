package com.lewis.roundup.models;

import java.io.Serializable;

public class SavingsGoal implements Serializable {

    private final String name;
    private final String currency;
    private final CurrencyAmount target;
    private final String base64EncodedPhoto;

    public SavingsGoal(String name, String currency, CurrencyAmount target, String base64EncodedPhoto) {
        this.name = name;
        this.currency = currency;
        this.target = target;
        this.base64EncodedPhoto = base64EncodedPhoto;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public CurrencyAmount getTarget() {
        return target;
    }

    public String getBase64EncodedPhoto() {
        return base64EncodedPhoto;
    }

    @Override
    public String toString() {
        return "SavingsGoal{" +
                "name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", target=" + target +
                ", base64EncodedPhoto='" + base64EncodedPhoto + '\'' +
                '}';
    }
}
