package client.controllers;

import client.ControllerInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.application.Platform;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements ControllerInterface {

    @FXML
    public TextArea messageTextFieldArea;
    public Button messageSendButton;

    @FXML
    public ListView listMessages;

    public String userName;
    public ObservableList<String> messages = FXCollections.observableArrayList();

    public ChatController()
    {
        userName = "Carl";
    }
    @FXML
    public void sendMessage()
    {

        messages.add(userName +" : "+ messageTextFieldArea.getText());
        messageTextFieldArea.clear();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        listMessages.setItems(messages);
    }

    @FXML
    public void closedApplication()
    {
        Platform.exit();
        System.exit(0);
    }

}
