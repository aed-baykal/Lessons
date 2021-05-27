package ru.geekbrains.java_two.april_chat.server.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrimitiveInMemoryAuthService implements AuthService {

    private List<User> users = new ArrayList<>();
    private Statement statement;
    private Connection connection;

    public PrimitiveInMemoryAuthService() {

        try {
            this.statement = connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbRead();
        disconnect();
    }

    static Statement connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:src/main/resources/chat_users.db")
                .createStatement();
    }

    private void dbRead() {
        try (ResultSet rs = statement.executeQuery("select UserID, UserLogin, UserPassword from users;")){
            while (rs.next()) {
                this.users.add(new User(("User" + rs.getString(1)), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void disconnect() {
        try {
            if(statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        System.out.println("Auth service started");
    }

    @Override
    public void stop() {
        System.out.println("Auth service stopped");
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password))
                return user.getUsername();
        }
        return null;
    }

    @Override
    public String changeUsername(String oldName, String newName) {
        return null;
    }

    @Override
    public String changePassword(String username, String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public User newUser() {
        return null;
    }
}
