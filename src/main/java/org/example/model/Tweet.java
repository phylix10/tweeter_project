package org.example.model;

public class Tweet {
    private int tweetId;
    private Account tweetUser;
    private String tweetContent;
    private int tweetLikeCount;
    private int commentCount;

    public Tweet() {
    }

    public Tweet(Account tweetUser, String tweetContent) {
        this.tweetUser = tweetUser;
        this.tweetContent = tweetContent;
    }

    public Tweet(int tweetId, Account tweetUser, String tweetContent) {
        this.tweetId = tweetId;
        this.tweetUser = tweetUser;
        this.tweetContent = tweetContent;
        tweetLikeCount = 0;
        commentCount = 0;
    }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public Account getTweetUser() {
        return tweetUser;
    }

    public void setTweetUser(Account tweetUser) {
        this.tweetUser = tweetUser;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    public void setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
    }

    public int getTweetLikeCount() {
        return tweetLikeCount;
    }

    public void setTweetLikeCount(int tweetLikeCount) {
        this.tweetLikeCount = tweetLikeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
