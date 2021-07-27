package com.lewis.roundup.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


public class TransactionTest {

    @Test
    public void calculateRoundupTest() {
        // given
        Transaction transaction = createTransaction("", 128);
        // when
        int roundupAmount = transaction.calculateRoundup();
        // then
        assertThat(roundupAmount).isEqualTo(72);
    }

    @Test
    public void true_isOutboundTest() {
        // given
        Transaction transaction = createTransaction("OUT", 0);
        // when
        boolean isOutbound = transaction.isOutbound();
        // then
        assertThat(isOutbound).isEqualTo(true);
    }

    @Test
    public void false_isOutboundTest() {
        // given
        Transaction transaction = createTransaction("IN", 0);
        // when
        boolean isOutbound = transaction.isOutbound();
        // then
        assertThat(isOutbound).isEqualTo(false);
    }

    private Transaction createTransaction(String direction, int minorUnits){
        CurrencyAmount currencyAmount = new CurrencyAmount("GPB", minorUnits);
        // TODO: ideally this would be created in some sort of test factory, to avoid cluttering the test
        return new Transaction("", "", currencyAmount, currencyAmount, direction, new Date(), new Date(), new Date(), "", "", "", "", "", "", "", "", "", "", "", "", true, true);
    }
}
