package org.example.repository;

import org.example.configuration.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Account;
import org.example.model.Tweet;

public class TweetRepository {
    private static final String INSERT_QUERY = "insert into twitte_table("+
            "twitte_user, twitte_content) values (?,?)";
    private static final String SELECT_QUERY = "select * from twitte_table t join account a on t.twitte_user = a.username";

    public static void createTweet(Tweet tweet) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1,tweet.getTweetUser().getId());
            preparedStatement.setString(2,tweet.getTweetContent());

            preparedStatement.execute();
            System.out.println("write one tweet");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static List<Tweet> showAllTweet(){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Tweet> tweets = new ArrayList<>();
            while (resultSet.next()) {
                Tweet tweet = new Tweet();
                tweet.setTweetId(resultSet.getInt("twitte_id"));
                tweet.setTweetUser((Account) resultSet.getObject("twitte_user"));
                tweet.setTweetContent(resultSet.getString("twitte_content"));
                tweet.setTweetLikeCount(resultSet.getInt("twitte_like_count"));
                tweet.setCommentCount(resultSet.getInt("twitte_comment_count"));
                tweets.add(tweet);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return tweets;

        } catch (
                SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return null;
    }
}
