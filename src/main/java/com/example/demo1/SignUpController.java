package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Controller class for the Sign-Up view.
 */
public class SignUpController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button submitButton;
    @FXML
    private Label button_login;

    /**
     * Handles the submission of the Sign-Up form.
     */
    @FXML
    private void handleSubmitButtonClick() {
        String username = usernameField.getText().trim(); // Trim to remove leading/trailing spaces
        String password = passwordField.getText().trim();

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter both username and password.");
            alert.showAndWait();
            return; // Exit method
        }

        try (Connection connection = DBUtils.getConnection()) {
            // Check if the username already exists
            String checkSql = "SELECT * FROM users WHERE username_ = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
                checkStatement.setString(1, username);
                ResultSet resultSet = checkStatement.executeQuery();
                if (resultSet.next()) {
                    // Username already exists, show error message
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Username already in use. Please choose another username.");
                    alert.showAndWait();
                    return; // Exit method
                }
            }

            // If username doesn't exist, proceed with signup
            String sql = "INSERT INTO users (username_, password) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                statement.executeUpdate();
            }
            // Display confirmation message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sign Up");
            alert.setHeaderText(null);
            alert.setContentText("Sign Up Successful! Welcome, " + username + "!");
            alert.showAndWait();
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error occurred while signing up. Please try again.");
            alert.showAndWait();
        }
    }
    /**
     * Handles the click event of the login label.
     * @param event The MouseEvent object representing the click event.
     */
    @FXML
    private void handleLoginLabelClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Stage stage = (Stage) button_login.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error occurred while loading login page.");
            alert.showAndWait();
        }
    }
}
