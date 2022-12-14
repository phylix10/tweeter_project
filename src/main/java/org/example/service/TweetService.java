package org.example.service;


import org.example.model.Account;
import org.example.model.Tweet;
import org.example.repository.TweetRepository;

import java.util.List;

public class TweetService {

    public void createTweet(Account account, String content) {
        Tweet tweets = new Tweet(account, content);
        TweetRepository.createTweet(tweets);
        System.out.println("tweet created successfully");
    }

    public static List<Tweet> showAllTweet() {
        return TweetRepository.showAllTweet();
    }
}
