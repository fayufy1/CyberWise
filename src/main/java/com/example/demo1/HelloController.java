package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
/**
 * Controller class for the Hello view.
 */
public class HelloController {
    @FXML
    private Label welcomeText;

    private HelloApplication helloApplication;

    /**
     * Injects the HelloApplication instance into this controller.
     * @param helloApplication The instance of HelloApplication to inject.
     */
    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    /**
     * Handles the Sign-Up button click event.
     */
    @FXML
    protected void onSignUpButtonClick() {
        try {
            // Open Sign Up page
            helloApplication.openSignUpPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Handles the Sign-In button click event.
     */
    @FXML
    protected void onSignInButtonClick() {
        try {
            // Open Login page
            helloApplication.openLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
