package GUI.Pages;

import javafx.geometry.HPos;
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

    MainPage() {
        super();
        // Disable Universal toolbar
        pageContainer.setTop(null);
        buildUI();
    }

    private void buildUI() {
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(5);
        // Build UI Components
        Label welcomeLabel = new Label("Welcome");
        welcomeLabel.setId("Bigtext");

        TextField nameTextField = new TextField();
        nameTextField.setPromptText("Username");

        Button loginBtn = new Button(" Login ");
        loginBtn.setOnAction(e -> nextPage());

        // Set location of components in GridPane
        GridPane.setConstraints(welcomeLabel, 0, 0);
        GridPane.setConstraints(nameTextField, 0, 1);
        GridPane.setConstraints(loginBtn, 0, 3);
        GridPane.setHalignment(welcomeLabel, HPos.CENTER);
        GridPane.setHalignment(loginBtn, HPos.CENTER);
        // Add components into GridPane
        contentPane.getChildren().addAll(welcomeLabel, nameTextField, loginBtn);

        welcomeLabel.requestFocus(); // to take away focus from textfield
    }

    @Override
    public void nextPage() {
        Window.setScene(Window.PAGE.OPTIONS);
    }

    @Override
    public void prevPage() {
        // Intentionally left blank
    }
}
