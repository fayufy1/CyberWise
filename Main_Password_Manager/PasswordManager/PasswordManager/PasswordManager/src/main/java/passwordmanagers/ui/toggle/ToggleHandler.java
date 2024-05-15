package passwordmanagers.ui.toggle;

import passwordmanagers.credentials.CredentialHandler;
import passwordmanagers.credentials.Type;
import passwordmanagers.ui.dialog.ExceptionDialog;
import passwordmanagers.ui.window.MainWindow;

public class ToggleHandler {

    private boolean shown = false;

    public void toggle (MainWindow mainWindow) {

        Type selected = mainWindow.getSideBar().getTreeBar().getSelected();
        CredentialHandler credentialHandler;

        if (shown)
            shown = false;
        else
            shown = true;

        try {
            credentialHandler = new CredentialHandler();

            mainWindow.getInnerContainer().setTableContent(credentialHandler
                    .generateObservableList(shown, selected, mainWindow.getVerifiedUser()));

            mainWindow.getInnerContainer().setShown(shown);

        } catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }

    public void setShown(boolean hide) {
        shown = false;
    }

    public boolean isShown() {
        return shown;
    }
}
