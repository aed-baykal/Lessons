package ru.geekbrains.java_two.april_chat.client;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.geekbrains.java_two.april_chat.client.network.ChatMessageService;
import ru.geekbrains.java_two.april_chat.client.network.ChatMessageServiceImpl;
import ru.geekbrains.java_two.april_chat.client.network.MessageProcessor;
import ru.geekbrains.java_two.april_chat.common.ChatMessage;
import ru.geekbrains.java_two.april_chat.common.MessageType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainChatController implements Initializable, MessageProcessor {

    private static final String PUBLIC = "PUBLIC";
    public TextArea chatArea;
    public ListView onlineUsers;
    public TextField inputField;
    public Button btnSendMessage;
    public TextField loginField;
    public PasswordField passwordField;
    public Button btnSendAuth;
    private ChatMessageService messageService;
    private String currentName;

    public void mockAction(ActionEvent actionEvent) {

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void showAbout(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/about.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("About");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void showHelp(ActionEvent actionEvent) {
    }

    public void sendMessage(ActionEvent actionEvent) {
        String text = inputField.getText();
        if (text.isEmpty()) return;
        ChatMessage msg = new ChatMessage();
        String adressee = (String) this.onlineUsers.getSelectionModel().getSelectedItem();
        if (adressee.equals(PUBLIC)) msg.setMessageType(MessageType.PUBLIC);
        else {
            msg.setMessageType(MessageType.PRIVATE);
            msg.setTo(adressee);
        }
        msg.setFrom(currentName);
        msg.setBody(text);
        messageService.send(msg.marshall());
        chatArea.appendText(String.format("[ME] %s\n", text));
        inputField.clear();
    }

    private void appendTextOfChat(ChatMessage msg) {
        if (msg.getFrom().equals(this.currentName)) return;
        String modifier = msg.getMessageType().equals(MessageType.PUBLIC) ? "[pub]" : "[priv]";
        String text = String.format("[%s] %s %s\n", msg.getFrom(), modifier, msg.getBody());
        chatArea.appendText(text);
    }

    private void showError(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Something went wrong!");
        alert.setHeaderText(e.getMessage());
        VBox dialog = new VBox();
        Label label = new Label("Trace:");
        TextArea textArea = new TextArea();
        StringBuilder builder = new StringBuilder();
        for (StackTraceElement el : e.getStackTrace()) {
            builder.append(el).append(System.lineSeparator());
        }
        textArea.setText(builder.toString());
        dialog.getChildren().addAll(label, textArea);
        alert.getDialogPane().setContent(dialog);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.messageService = new ChatMessageServiceImpl("localhost", 12256, this);
        messageService.connect();
    }

    @Override
    public void processMessage(String msg) {
        Platform.runLater(() -> {
            ChatMessage message = ChatMessage.unmarshall(msg);
            System.out.println("Received message");

            switch (message.getMessageType()) {
                case PRIVATE:
                case PUBLIC:
                    appendTextOfChat(message);
                    break;
                case CLIENT_LIST:
                    refreshOnlineUsers(message);
                    break;
                case AUTH_CONFIRM:
                    this.currentName = message.getBody();
                    App.stage1.setTitle(currentName);
                    break;
            }
        });
    }

    private void refreshOnlineUsers(ChatMessage message) {
        message.getOnlineUsers().add(0, PUBLIC);
        this.onlineUsers.setItems(FXCollections.observableArrayList(message.getOnlineUsers()));
        this.onlineUsers.getSelectionModel().selectFirst();
    }

    public void sendAuth(ActionEvent actionEvent) {
        String log = loginField.getText();
        String pass = passwordField.getText();
        if (log.isEmpty() || pass.isEmpty()) return;
        ChatMessage msg = new ChatMessage();
        msg.setMessageType(MessageType.SEND_AUTH);
        msg.setLogin(log);
        msg.setPassword(pass);
        messageService.send(msg.marshall());
    }
}

