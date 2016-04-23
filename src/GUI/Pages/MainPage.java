package GUI.Pages;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

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

       // BorderPane bp = new BorderPane();
       // pageContainer.setPadding(new Insets(400,100,400,100));


        /*//DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(7);*/

        // Build UI Components
        Label welcomeLabel = new Label("Welcome");
        //welcomeLabel.setEffect(dropShadow);
        welcomeLabel.setId("welcomeLabel");

        TextField nameTextField = new TextField();
        nameTextField.setPromptText("Username");

        Button loginBtn = new Button(" Login ");
        loginBtn.setId("loginButton");
        loginBtn.setOnAction(e -> nextPage());


        // Set location of components in GridPane
        GridPane.setConstraints(welcomeLabel, 0, 0);
        GridPane.setConstraints(nameTextField, 0, 3);
        GridPane.setConstraints(loginBtn, 0, 5);
        GridPane.setHalignment(welcomeLabel, HPos.CENTER);
        GridPane.setHalignment(loginBtn, HPos.CENTER);
        //Reflection for gridPane
       /* Reflection r = new Reflection();
        r.setFraction(0.7f);
        contentPane.setEffect(r);*/

        //pageContainer.setId("bp1");
        //contentPane.setId("root1");
        loginBtn.setId("loginButton");


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
