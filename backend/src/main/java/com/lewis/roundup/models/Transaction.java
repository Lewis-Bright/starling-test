package com.lewis.roundup.models;

import java.util.Date;

public class Transaction {

    private static final String OUTBOUND_KEY = "OUT";

    private final String feedItemUid;

    private final String categoryUid;

    private final CurrencyAmount amount;

    private final CurrencyAmount sourceAmount;

    private final String direction;

    private final Date updatedAt;

    private final Date transactionTime;

    private final Date settlementTime;

    private final String source;

    private final String status;

    private final String counterPartyType;

    private final String counterPartyUid;

    private final String counterPartyName;

    private final String counterPartySubEntityUid;

    private final String counterPartySubEntityName;

    private final String counterPartySubEntityIdentifier;

    private final String counterPartySubEntitySubIdentifier;

    private final String reference;

    private final String country;

    private final String spendingCategory;

    private final boolean hasAttachment;

    private final boolean hasReceipt;

    public Transaction(String feedItemUid, String categoryUid, CurrencyAmount amount, CurrencyAmount sourceAmount, String direction, Date updatedAt, Date transactionTime, Date settlementTime, String source, String status, String counterPartyType, String counterPartyUid, String counterPartyName, String counterPartySubEntityUid, String counterPartySubEntityName, String counterPartySubEntityIdentifier, String counterPartySubEntitySubIdentifier, String reference, String country, String spendingCategory, boolean hasAttachment, boolean hasReceipt) {
        this.feedItemUid = feedItemUid;
        this.categoryUid = categoryUid;
        this.amount = amount;
        this.sourceAmount = sourceAmount;
        this.direction = direction;
        this.updatedAt = updatedAt;
        this.transactionTime = transactionTime;
        this.settlementTime = settlementTime;
        this.source = source;
        this.status = status;
        this.counterPartyType = counterPartyType;
        this.counterPartyUid = counterPartyUid;
        this.counterPartyName = counterPartyName;
        this.counterPartySubEntityUid = counterPartySubEntityUid;
        this.counterPartySubEntityName = counterPartySubEntityName;
        this.counterPartySubEntityIdentifier = counterPartySubEntityIdentifier;
        this.counterPartySubEntitySubIdentifier = counterPartySubEntitySubIdentifier;
        this.reference = reference;
        this.country = country;
        this.spendingCategory = spendingCategory;
        this.hasAttachment = hasAttachment;
        this.hasReceipt = hasReceipt;
    }

    public String getFeedItemUid() {
        return feedItemUid;
    }

    public String getCategoryUid() {
        return categoryUid;
    }

    public CurrencyAmount getAmount() {
        return amount;
    }

    public CurrencyAmount getSourceAmount() {
        return sourceAmount;
    }

    public String getDirection() {
        return direction;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public Date getSettlementTime() {
        return settlementTime;
    }

    public String getSource() {
        return source;
    }

    public String getStatus() {
        return status;
    }

    public String getCounterPartyType() {
        return counterPartyType;
    }

    public String getCounterPartyUid() {
        return counterPartyUid;
    }

    public String getCounterPartyName() {
        return counterPartyName;
    }

    public String getCounterPartySubEntityUid() {
        return counterPartySubEntityUid;
    }

    public String getCounterPartySubEntityName() {
        return counterPartySubEntityName;
    }

    public String getCounterPartySubEntityIdentifier() {
        return counterPartySubEntityIdentifier;
    }

    public String getCounterPartySubEntitySubIdentifier() {
        return counterPartySubEntitySubIdentifier;
    }

    public String getReference() {
        return reference;
    }

    public String getCountry() {
        return country;
    }

    public String getSpendingCategory() {
        return spendingCategory;
    }

    public boolean isHasAttachment() {
        return hasAttachment;
    }

    public boolean isHasReceipt() {
        return hasReceipt;
    }

    public boolean isOutbound() {
        return direction.equals(OUTBOUND_KEY);
    }

    public int calculateRoundup() {
        // This would need to change depending on the round up "target". We are only
        // concerned with the nearest pound, in GBP, so this is ok for our use case
        return 100 - Math.abs(amount.getMinorUnits()) % 100;
    }
}
