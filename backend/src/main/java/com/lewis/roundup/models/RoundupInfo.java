package com.lewis.roundup.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;

public class RoundupInfo {

    private final BigDecimal totalSavings;

    private final BigDecimal totalSavingsInPounds;

    private final int numberOfTransactions;

    private final ZonedDateTime startDate;

    private final ZonedDateTime endDate;

    /**
     * This isn't really being used in the end, but could be stored in a database to keep a log of all of the
     * calculations that have been done
     */
    public RoundupInfo(BigDecimal totalSavings, int numberOfTransactions, ZonedDateTime startDate, ZonedDateTime endDate) {
        this.totalSavings = totalSavings;
        totalSavingsInPounds = totalSavings.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
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

    public BigDecimal getTotalSavingsInPounds() {
        return totalSavingsInPounds;
    }
}
