package org.example.service;

import org.example.model.Account;
import org.example.repository.AccountRepository;


public class AccountService {
    private Account loggedInUser = null;
    private TweetService tweetService = new TweetService();

    public void creatTweet(String content){
        tweetService.createTweet(loggedInUser,content);
    }

    public boolean register(String username, String password) {
        if (AccountRepository.findAccount(username) == null) {
            Account account = new Account(username, password);
            AccountRepository.createAccount(account);
            return true;
        }
        return false;
    }

    public boolean login(String username, String password) {
        Account account = AccountRepository.findAccount(username);
        if (account != null) {
            if (account.getPassword().equals(password)){
                loggedInUser = account;
                return true;
            }
        }
        return false;
    }
}