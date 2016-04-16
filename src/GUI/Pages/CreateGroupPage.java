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
class CreateGroupPage extends Page {

    CreateGroupPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setId("pagethree");
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(5);

        // Build UI Components
        Label createGroupLabel = new Label("Create A Group");
        createGroupLabel.setId("pagefour");

        Label groupNameLabel = new Label("Group Name: ");
        groupNameLabel.setId("pagefour");

        TextField groupNameTextField = new TextField();

        Label pincodeLabel = new Label("Pincode: ");
        pincodeLabel.setId("pagefour");

        TextField pincodeTextField = new TextField();
        pincodeTextField.setPromptText("Optional");

        Button createGroupButton = new Button("Create Group");
        createGroupButton.setOnAction(e -> nextPage());

        // Set location of components in GridPane
        GridPane.setConstraints(createGroupLabel, 0, 0);
        GridPane.setConstraints(groupNameLabel, 0, 1);
        GridPane.setConstraints(groupNameTextField, 1, 1);
        GridPane.setConstraints(pincodeLabel, 0, 2);
        GridPane.setConstraints(pincodeTextField, 1, 2);
        GridPane.setConstraints(createGroupButton, 3, 3);

        // Add components into GridPane
        contentPane.getChildren().addAll(groupNameLabel, pincodeLabel, createGroupLabel, createGroupButton, groupNameTextField, pincodeTextField);
    }

    @Override
    public void nextPage() {
        Window.setScene(Window.PAGE.CREATEPLAYLIST);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.OPTIONS);
    }
}
