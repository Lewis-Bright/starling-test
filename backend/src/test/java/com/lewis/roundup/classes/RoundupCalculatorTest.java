package com.lewis.roundup.classes;

import com.lewis.roundup.models.Account;
import com.lewis.roundup.models.CurrencyAmount;
import com.lewis.roundup.models.Feed;
import com.lewis.roundup.models.Transaction;
import com.lewis.roundup.services.StarlingRestService;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class RoundupCalculatorTest {

    private final StarlingRestService mockService = mock(StarlingRestService.class);

    private final RoundupCalculator roundupCalculator = new RoundupCalculator();

    @BeforeEach
    public void setup() {
        roundupCalculator.setStarlingRestService(mockService);
    }

    @Test
    public void calculateTest() {
        // given
        Account account = mock(Account.class);
        Transaction mockTransaction1 = mock(Transaction.class);
        given(mockTransaction1.calculateRoundup()).willReturn(50);
        given(mockTransaction1.isOutbound()).willReturn(true);
        Transaction mockTransaction2 = mock(Transaction.class);
        given(mockTransaction2.calculateRoundup()).willReturn(30);
        given(mockTransaction2.isOutbound()).willReturn(true);
        Feed feed = new Feed();
        feed.setFeedItems(List.of(mockTransaction1, mockTransaction2));
        given(mockService.getFeed(
                eq(account),
                any(ZonedDateTime.class),
                any(ZonedDateTime.class),
                any(String.class))
        ).willReturn(feed);
        // when
        BigDecimal totalSavings = roundupCalculator.calculate(account, "AUTH").getTotalSavings();
        // then
        assertThat(totalSavings).isEqualTo(BigDecimal.valueOf(80));
    }
}
