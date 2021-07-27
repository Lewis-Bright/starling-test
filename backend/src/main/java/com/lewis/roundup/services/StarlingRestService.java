package com.lewis.roundup.services;

import com.lewis.roundup.models.Account;
import com.lewis.roundup.models.Accounts;
import com.lewis.roundup.models.Feed;
import com.lewis.roundup.models.SavingsGoal;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Service
public class StarlingRestService {

    private static final String BASE_URL = "https://api-sandbox.starlingbank.com/api/v2/";

    private static final String ACCOUNT_ENDPOINT = BASE_URL + "accounts";

    private static final String TRANSACTIONS_ENDPOINT = BASE_URL + "feed/account/%s/category/%s/transactions-between";

    private static final String SAVINGS_GOAL_ENDPOINT = BASE_URL + "account/%s/savings-goals";

    private final RestTemplate restTemplate;

    public StarlingRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static HttpHeaders getHeaders(String auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(auth);
        return headers;
    }

    public Accounts getAccounts(String auth) {
        HttpEntity<String> entity = new HttpEntity<>("body", getHeaders(auth));

        return restTemplate.exchange(
                ACCOUNT_ENDPOINT,
                HttpMethod.GET,
                entity,
                Accounts.class).getBody();
    }

    /**
     * Get the last week's worth of transactions for the given account's default category
     */
    public Feed getFeed(Account account, ZonedDateTime start, ZonedDateTime end, String auth) {
        String baseUrl = String.format(TRANSACTIONS_ENDPOINT, account.getAccountUid(), account.getDefaultCategory());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("minTransactionTimestamp", formatDateTime(start))
                .queryParam("maxTransactionTimestamp", formatDateTime(end));

        HttpEntity<?> entity = new HttpEntity<>(getHeaders(auth));

        return restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Feed.class).getBody();
    }

    public void createSavingsGoal(Account account, SavingsGoal savingsGoal, String auth) {
        String resourceUrl = String.format(SAVINGS_GOAL_ENDPOINT, account.getAccountUid());
        HttpEntity<SavingsGoal> requestUpdate = new HttpEntity<>(savingsGoal, getHeaders(auth));
        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
    }

    private String formatDateTime(ZonedDateTime zonedDateTime) {
        return zonedDateTime.format(DateTimeFormatter.ISO_INSTANT);
    }
}