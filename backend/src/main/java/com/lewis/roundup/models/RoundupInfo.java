package com.lewis.roundup.models;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class RoundupInfo {

    private final BigDecimal totalSavings;

    private final int numberOfTransactions;

    private final ZonedDateTime startDate;

    private final ZonedDateTime endDate;

    public RoundupInfo(BigDecimal totalSavings, int numberOfTransactions, ZonedDateTime startDate, ZonedDateTime endDate) {
        this.totalSavings = totalSavings;
        this.numberOfTransactions = numberOfTransactions;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BigDecimal getTotalSavings() {
        return totalSavings;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }
}
