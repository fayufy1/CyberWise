package com.example.demo1;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


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

    /**
     * Handles the Try Now button click event for the Educational Resources Hub.
     */
    @FXML
    protected void onTryNowEducationalResourcesHubClick() {
        try {
            // Open Educational Resources Hub page
            helloApplication.openEducationalResourcesHubPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleCyberbullyingGuideLink() {
        openWebpage("https://example.com/cyberbullying-guide");
    }

    @FXML
    private void handleCyberbullyingPreventionLink() {
        openWebpage("https://www.nsw.gov.au/education-and-training/digital-citizenship/parents-and-carers/managing-cyberbullying#:~:text=Don't%20reply%20or%20respond,teachers%20and%20parents%20will%20help.");
    }

    @FXML
    private void handleCyberbullyingResponseLink() {
        openWebpage("https://example.com/cyberbullying-response");
    }

    @FXML
    private void handlePhishingTacticsLink() {
        openWebpage("https://example.com/phishing-tactics");
    }

    @FXML
    private void handlePhishingProtectionLink() {
        openWebpage("https://example.com/phishing-protection");
    }

    @FXML
    private void handlePhishingSimulationLink() {
        openWebpage("https://example.com/phishing-simulation");
    }

    @FXML
    private void handleMalwareTypesLink() {
        openWebpage("https://example.com/malware-types");
    }

    @FXML
    private void handleMalwarePreventionLink() {
        openWebpage("https://example.com/malware-prevention");
    }

    @FXML
    private void handleMalwareRemovalLink() {
        openWebpage("https://example.com/malware-removal");
    }

    @FXML
    private void handleIdentityProtectionLink() {
        openWebpage("https://example.com/identity-protection");
    }

    @FXML
    private void handleIdentityTheftStepsLink() {
        openWebpage("https://example.com/identity-theft-steps");
    }

    @FXML
    private void handleIdentityTheftUnderstandingLink() {
        openWebpage("https://example.com/identity-theft-understanding");
    }

    @FXML
    private void handleSocialMediaPrivacyLink() {
        openWebpage("https://example.com/social-media-privacy");
    }

    @FXML
    private void handleSocialMediaSafetyLink() {
        openWebpage("https://example.com/social-media-safety");
    }

    @FXML
    private void handleSocialMediaGuideLink() {
        openWebpage("https://example.com/social-media-guide");
    }

    private void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
