package ru.geekbrains.java_two.april_chat.server.auth;

public interface AuthService {
    void start();
    void stop();
    String getUsernameByLoginAndPassword(String login, String password);
    String changeUsername(String oldName, String newName);
    String changePassword(String username, String oldPassword, String newPassword);

}
