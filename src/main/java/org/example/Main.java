package org.example;

import org.example.service.AccountService;
import org.example.service.TweetService;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
//        System.out.println(accountService.register("ali","123456"));
        System.out.println(accountService.login("ali","123456"));
        accountService.creatTweet("hello world");

    }
}
