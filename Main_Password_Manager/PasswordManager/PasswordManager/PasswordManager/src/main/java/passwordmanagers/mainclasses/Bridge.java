package passwordmanagers.mainclasses;

import passwordmanagers.ui.window.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Bridge extends Application {

    public void start(Stage stage) throws Exception {

        new MainWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
