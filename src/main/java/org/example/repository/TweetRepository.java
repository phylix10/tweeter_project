package org.example.repository;

import org.example.configuration.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.model.Tweet;

public class TweetRepository {
    private static final String INSERT_QUERY = "insert into twitte_table("+
            "twitte_id, twitte_user, twitte_content, twitte_like_count,twitte_comment_count) values (?,?,?,?,?)";

    public static void createTweet(Tweet tweet) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, tweet.getTweetId());
            preparedStatement.setObject(2, tweet.getTweetUser());
            preparedStatement.setString(3, tweet.getTweetContent());
            preparedStatement.setInt(4, tweet.getTweetLikeCount());
            preparedStatement.setInt(5, tweet.getCommentCount());

            preparedStatement.execute();
            System.out.println("write one tweet");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
}
