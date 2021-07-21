package com.lewis.roundup.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SavingsGoalInfo {

    private @Id @GeneratedValue Long id;

    private final int totalSavings;

    private final int numberOfTransactions;

    private final Date startDate;

    private final Date endDate;

    public SavingsGoalInfo(int totalSavings, int numberOfTransactions, Date startDate, Date endDate) {
        this.totalSavings = totalSavings;
        this.numberOfTransactions = numberOfTransactions;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalSavings() {
        return totalSavings;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
