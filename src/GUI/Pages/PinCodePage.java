package GUI.Pages;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Created by Zubair on 4/18/16.
 */
public class PinCodePage extends Page {


    public PinCodePage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setId("pageten");
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(5);

        // Build UI Components
        TextField pincodeTextField = new TextField();
        pincodeTextField.setPromptText("Pin Code");

        Label createpinLabel = new Label("Enter Pin Code: ");
        createpinLabel.setId("Bigtext");


        Button createEnterButton = new Button("Enter");
        createEnterButton.setOnAction(e -> nextPage());


        // Set location of components in GridPane
        GridPane.setConstraints(createpinLabel, 0, 0);
        GridPane.setConstraints(pincodeTextField, 0, 2);
        GridPane.setConstraints(createEnterButton, 0, 3);
        GridPane.setHalignment(createpinLabel, HPos.CENTER);
        GridPane.setHalignment(createEnterButton, HPos.CENTER);



        // Add components into GridPane
        contentPane.getChildren().addAll(createpinLabel, createEnterButton, pincodeTextField);
    }

    @Override
    public void nextPage() {
        Window.setScene(Window.PAGE.CLIENT_PLAYER);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.HOSTLIST);
    }
}
