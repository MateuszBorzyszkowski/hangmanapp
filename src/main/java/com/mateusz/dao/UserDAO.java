package com.mateusz.dao;

import com.mateusz.client.SqlClientDB;
import com.mateusz.model.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    private final Connection connection;

    public UserDAO() {
        this.connection = SqlClientDB.getConnection();
    }

    public boolean addUser(User user) {
        String myLogin = user.getUserLogin();
        String myPassword = user.getUserPassword();

        if(!compareUser(new User(myLogin, myPassword))) {
            PreparedStatement statement = null;

            try {
                String query = "INSERT INTO user (userFirstName, userLastName, userLogin, userPassword, userScore) VALUES (?,?,?,?,?)";
                statement = connection.prepareStatement(query, statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getUserFirstName());
                statement.setString(2, user.getUserLastName());
                statement.setString(3, user.getUserLogin());
                statement.setString(4, user.getUserPassword());
                statement.setString(5, "0");
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

//    public int sizeOfTable() {
//
//        Statement statement = null;
//        int count = 0;
//
//        try {
//            statement = connection.createStatement();
//            String query = "SELECT COUNT (*) AS id FROM user;";
//            ResultSet resultSet = statement.executeQuery(query);
//            resultSet.next();
////            System.out.println(resultSet.getInt("id"));
//            count = resultSet.getInt("id");
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return count;
//    }

    public Map<String, Integer> searchStats (User user, String cookieValue) {
        Map<String, Integer> stats = new HashMap<>();
        String myLogin = cookieValue;

        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "SELECT userLogin, userScore FROM user WHERE userLogin = '" + myLogin + "';";
            ResultSet resultSet = statement.executeQuery(query);

            stats.put(resultSet.getString("userLogin"),Integer.parseInt(resultSet.getString("userScore")));

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stats;
    }

    public Map<String, Integer> searchRowOfUser (User user) {
        Map<String, Integer> rowOfUser = new HashMap<>();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "SELECT userLogin, userScore FROM user ORDER BY userScore, userLogin;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
//                System.out.println(resultSet.getString("userLogin") + " " + resultSet.getString("userScore"));
                rowOfUser.put(resultSet.getString("userLogin"),Integer.parseInt(resultSet.getString("userScore")));
            }

            resultSet.close();
            statement.close();
//            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowOfUser;
    }

    public boolean scoreUser(User user, String cookieValue, String oldScore) {
        String myLogin = cookieValue;
        String myScore = user.getUserScore();
        Integer myScoreInt;
        Integer myOldScoreInt;
        boolean newBetter = false;

        try {
            myScoreInt = Integer.parseInt(myScore);
            myOldScoreInt = Integer.parseInt(oldScore);
            if (myScoreInt > myOldScoreInt) newBetter = true;
            else newBetter = false;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (newBetter) {
            try {
                String query = "UPDATE user SET userScore = ? WHERE userLogin = ?;";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, myScore);
                preparedStmt.setString(2, myLogin);
                preparedStmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            System.out.println("Score is worse!");
            return false;
        }
    }

    public String oldScoreUser(String cookieValue) {
        Statement statement = null;

        String myLogin = cookieValue;
        String myScore = null;
        try {
            statement = connection.createStatement();
            String query = "SELECT userScore FROM user WHERE userLogin='" + myLogin + "';";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println(resultSet.getString("userScore"));
            myScore = resultSet.getString("userScore");

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myScore;
    }

    public boolean findUser(User user) {
        Statement statement = null;

        String myLogin = user.getUserLogin();
        String myPassword = user.getUserPassword();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM user WHERE userLogin='" + myLogin + "' AND userPassword='" + myPassword + "';";
            ResultSet resultSet = statement.executeQuery(query);


            System.out.println(resultSet.getString("userLogin"));
            System.out.println(resultSet.getString("userPassword"));
            System.out.println("OK");

            resultSet.close();
            statement.close();
//            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("NO OK");
            return false;
        }
        return true;
    }

    public boolean compareUser(User user) {
        Statement statement = null;

        String myLogin = user.getUserLogin();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM user WHERE userLogin='" + myLogin + "';";
            ResultSet resultSet = statement.executeQuery(query);


            System.out.println(resultSet.getString("userLogin"));
            System.out.println("OK");

            resultSet.close();
            statement.close();
//            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("NO OK");
            return false;
        }
        return true;
    }
}
