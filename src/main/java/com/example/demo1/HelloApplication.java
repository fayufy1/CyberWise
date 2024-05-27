package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main application class responsible for launching the CyberWise Home Page.
 */
public class HelloApplication extends Application {
    private HelloController helloController;

    /**
     * Starts the CyberWise Home Page application.
     * @param primaryStage The primary stage of the application.
     * @throws IOException If an error occurs during loading of the FXML file.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();

        // Get the controller instance
        helloController = fxmlLoader.getController();

        // Inject HelloApplication instance into HelloController
        helloController.setHelloApplication(this);

        primaryStage.setTitle("CyberWise Home Page");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Opens the Sign-Up page.
     * @throws IOException If an error occurs during loading of the FXML file.
     */
    public void openSignUpPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign_up.fxml"));
        Parent root = fxmlLoader.load();
        Stage signUpStage = new Stage();
        signUpStage.setScene(new Scene(root));
        signUpStage.setTitle("Sign Up");
        signUpStage.show();
    }

    /**
     * Opens the Login page.
     * @throws IOException If an error occurs during loading of the FXML file.
     */
    public void openLoginPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        Stage loginStage = new Stage();
        loginStage.setScene(new Scene(root));
        loginStage.setTitle("Login");
        loginStage.show();
    }

    /**
     * Opens the Educational Resources Hub page.
     * @throws IOException If an error occurs during loading of the FXML file.
     */
    public void openEducationalResourcesHubPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EducationalResourcesHub.fxml"));
        Parent root = fxmlLoader.load();
        Stage educationalResourcesHubStage = new Stage();
        educationalResourcesHubStage.setScene(new Scene(root));
        educationalResourcesHubStage.setTitle("Educational Resources Hub");
        educationalResourcesHubStage.show();
    }

    /**
     * The main entry point for the application.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}
