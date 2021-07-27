package com.lewis.roundup.classes;

import com.lewis.roundup.models.Account;
import com.lewis.roundup.models.RoundupInfo;
import com.lewis.roundup.models.Feed;
import com.lewis.roundup.models.Transaction;
import com.lewis.roundup.services.StarlingRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Component
public class RoundupCalculator {

    @Autowired
    private StarlingRestService starlingRestService;

    public RoundupInfo calculate(Account account, String auth) {

        LocalDate now = LocalDate.now(ZoneOffset.UTC);
        LocalDate sevenDaysAgo = now.minusDays(7);

        ZonedDateTime start = ZonedDateTime.of(sevenDaysAgo, LocalTime.now(), ZoneOffset.UTC);
        ZonedDateTime end = ZonedDateTime.now(ZoneOffset.UTC);
        Feed feed = starlingRestService.getFeed(account, start, end, auth);
        BigDecimal savingsGoal = feed.getFeedItems().stream()
                .filter(Transaction::isOutbound)
                .map(Transaction::calculateRoundup)
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(savingsGoal);
        int transactionCount = feed.getFeedItems().size();

        return new RoundupInfo(savingsGoal, transactionCount, start, end);
    }

    public void setStarlingRestService(StarlingRestService starlingRestService) {
        this.starlingRestService = starlingRestService;
    }
}
