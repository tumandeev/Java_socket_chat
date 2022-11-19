package client.controllers;

import client.ControllerInterface;
import client.RunMessenger;
import javafx.fxml.FXML;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements ControllerInterface {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField textField;

    @FXML
    private CheckBox checkBox;
    @FXML
    protected void onHelloButtonClick() {
        checkBox.setSelected(!checkBox.isSelected());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}