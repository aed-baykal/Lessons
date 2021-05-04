package ru.geekbrains.JavaTwo.chat.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.geometry.NodeOrientation.LEFT_TO_RIGHT;
import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;

public class MainChatController {

    public TextArea chatArea;
    public ListView onlineUsers;
    public TextField inputField;
    public Button btnSendMessage;

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
        appendTextOfChat("ME");
    }

    private void appendTextOfChat(String author) {
        String msg = inputField.getText();
        if (msg.isEmpty()) return;
        if (author.equals("ME")) {
            chatArea.setNodeOrientation(LEFT_TO_RIGHT);
        }
        // Строка ниже делает выравнивание текста по пправому краю
        else chatArea.setNodeOrientation(RIGHT_TO_LEFT);
        chatArea.setWrapText(true);
        chatArea.appendText(author + ": " + msg + System.lineSeparator());
        inputField.clear();
    }
}
