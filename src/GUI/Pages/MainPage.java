package GUI.Pages;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by davidsabzanov on 4/11/16.
 * Project: Sync
 */
class MainPage extends Page {

    MainPage(Stage primaryStage) {
        super(primaryStage);

        // Disable Universal toolbar
        universalToolbar.setVisible(false);
        buildUI();
    }

    private void buildUI() {
        contentPane.setId("mainpage");
        contentPane.setAlignment(Pos.CENTER);

        // Build UI Components
        Label welcomeLabel = new Label("Welcome to SYNC");
        welcomeLabel.setId("Bigtext");

        Label btNameLabel = new Label("Bluetooth Name: ");
        btNameLabel.setId("pagefour");

        TextField nameTextField = new TextField();

        Button loginBtn = new Button(" Login ");
        loginBtn.setOnAction(e -> nextPage());

        // Set location of components in GridPane
        GridPane.setConstraints(btNameLabel, 0, 3);
        GridPane.setConstraints(welcomeLabel, 1, 0);
        GridPane.setConstraints(nameTextField, 1, 3);
        GridPane.setConstraints(loginBtn, 2, 5);

        // Add components into GridPane
        contentPane.getChildren().addAll(welcomeLabel, btNameLabel, nameTextField, loginBtn);
    }

    @Override
    public void nextPage() {
        primaryStage.setScene(new OptionsPage(primaryStage));
    }

    @Override
    public void prevPage() {
        // Intentionally left blank
    }
}
