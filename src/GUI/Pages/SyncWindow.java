package GUI.Pages;
/**
 * Created by Mac on 3/16/16.
 * Project: Sync
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.String;


public class SyncWindow extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sync 1.0");
        primaryStage.setScene(new MainPage(primaryStage));
        primaryStage.show();
    }
}

