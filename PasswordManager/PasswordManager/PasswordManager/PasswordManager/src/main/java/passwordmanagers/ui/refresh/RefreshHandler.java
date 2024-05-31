package passwordmanagers.ui.refresh;

import passwordmanagers.credentials.CredentialHandler;
import passwordmanagers.credentials.Type;
import passwordmanagers.ui.dialog.ExceptionDialog;
import passwordmanagers.ui.toggle.ToggleHandler;
import passwordmanagers.ui.window.MainWindow;
import passwordmanagers.users.User;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class RefreshHandler {

    public static void refresh(MainWindow mainWindow) {

        // determines which tree item is selected and refreshes the list of credentials associated with it.
        ToggleHandler toggleHandler = mainWindow.getToggleHandler();
        Type selected = mainWindow.getSideBar().getTreeBar().getSelected();
        User verifiedUser = mainWindow.getVerifiedUser();

        try {
            CredentialHandler credentialHandler = new CredentialHandler();
            //updates table to reflect the updates to the credential list.
            mainWindow.getInnerContainer().setTableContent(credentialHandler
                    .generateObservableList(toggleHandler.isShown(), selected, verifiedUser));
        } catch (IOException | GeneralSecurityException ex) {
            new ExceptionDialog(ex);
        }
    }
}
