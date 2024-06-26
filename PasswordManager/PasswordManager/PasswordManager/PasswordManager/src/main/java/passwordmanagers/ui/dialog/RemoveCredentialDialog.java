package passwordmanagers.ui.dialog;

import passwordmanagers.credentials.Credential;
import passwordmanagers.credentials.CredentialHandler;
import passwordmanagers.ui.refresh.RefreshHandler;
import passwordmanagers.ui.window.MainWindow;
import passwordmanagers.users.User;
import passwordmanagers.users.UserHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Optional;

public class RemoveCredentialDialog {

    private MainWindow mainWindow;

    private final User verifiedUser;
    private UserHandler userHandler;

    private Credential selectedCredential;

    private CredentialHandler credentialHandler;

    public RemoveCredentialDialog(MainWindow mainWindow) {

        this.mainWindow = mainWindow;

        verifiedUser = mainWindow.getVerifiedUser();
        selectedCredential = mainWindow.getInnerContainer().getSelectedRow(); // the row that is selected on the table.

        try {
            userHandler = new UserHandler();
            credentialHandler = new CredentialHandler();
        } catch (IOException | GeneralSecurityException ex) {
            new ExceptionDialog(ex);
        }

        showDialog();
    }

    public void showDialog() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove credential");
        alert.setHeaderText("Remove credential");
        alert.setContentText("Are you sure you want to remove this entry?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            try {
                userHandler.removeCredential(verifiedUser, selectedCredential); //removes credential from collection in verifiedUser.
                RefreshHandler.refresh(mainWindow); // updates table to reflect removal of credential.
                new SuccessDialog("That entry has successfully been removed",
                        "Credential has been removed");
            } catch (IOException ex) {
                new ExceptionDialog(ex);
            }
        }
    }
}
