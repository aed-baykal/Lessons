package ru.geekbrains.java_two.april_chat.client.network;

public interface ChatMessageService {
    void send(String msg);
    void receive(String msg);
    void connect();
}
