package client.controllers;

import client.ControllerInterface;
import client.RunMessenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements ControllerInterface {

    @FXML
    public TextArea messageTextFieldArea;
    public Button messageSendButton;

    @FXML
    public ListView listMessages;

    public String userName;
    public String currentText;
    public ObservableList<String> messages = FXCollections.observableArrayList();

    public ChatController()
    {
        userName = "Carl";
    }
    @FXML
    public void sendMessage()
    {

        currentText = messageTextFieldArea.getText();
        Task<HBox> othersMessages = new Task<HBox>() {
            @Override
            public HBox call() throws Exception {
                Image image = new Image(RunMessenger.class.getResource("images/empty_avatar.jpg").openStream());
                ImageView profileImage = new ImageView(image);
                profileImage.setFitHeight(32);
                profileImage.setFitWidth(32);
                Label text = new Label();
                text.setText(userName + ": " + currentText);

                text.setBackground(new Background(new BackgroundFill(Color.WHITE,null, null)));
                HBox messageItem = new HBox();

                messageItem.getChildren().addAll((Node) profileImage, (Node) text);

                return messageItem;
            }
        };

        othersMessages.setOnSucceeded(event -> {
            listMessages.getItems().add(othersMessages.getValue());
        });

        Thread thread = new Thread(othersMessages);
        thread.setDaemon(true);
        thread.start();
        messageTextFieldArea.clear();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
//        listMessages.setItems(messages);
    }

    @FXML
    public void closedApplication()
    {
        Platform.exit();
        System.exit(0);
    }

}
