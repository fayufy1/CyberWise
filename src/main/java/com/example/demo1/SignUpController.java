package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private void handleSubmitButtonClick() {
        // Code to handle sign-up submission
        // For example:
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Perform sign-up logic here...

        // Display confirmation message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sign Up");
        alert.setHeaderText(null);
        alert.setContentText("Sign Up Successful! Welcome, " + username + "!");
        alert.showAndWait();

        // You can close the sign-up window or navigate to another page here
    }
}
