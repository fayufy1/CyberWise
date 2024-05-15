package passwordmanagers.ui.toolbar;

import passwordmanagers.ui.dialog.Choice;
import passwordmanagers.ui.dialog.ChoiceCredentialDialog;
import passwordmanagers.ui.dialog.RemoveCredentialDialog;
import passwordmanagers.ui.window.MainWindow;

public class ToolBarHandler {

    public static void onAddButtonClick(MainWindow mainWindow) {

        new ChoiceCredentialDialog(Choice.ADD, mainWindow);
    }

    public static void onEditButtonClick(MainWindow mainWindow) {

        new ChoiceCredentialDialog(Choice.EDIT, mainWindow);
    }

    public static void onRemoveButtonClick(MainWindow mainWindow) {

        new RemoveCredentialDialog(mainWindow);
    }
}
