package com.lewis.roundup.models;

import java.util.List;

/**
 * Simply holds the feed items, so they can easily be read from the rest api response
 */
public class Feed {

    private List<Transaction> feedItems;

    public List<Transaction> getFeedItems() {
        return feedItems;
    }

    public void setFeedItems(List<Transaction> feedItems) {
        this.feedItems = feedItems;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "feedItems=" + feedItems +
                '}';
    }
}
