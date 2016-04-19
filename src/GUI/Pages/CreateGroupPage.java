package GUI.Pages;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Created by davidsabzanov on 4/11/16.
 * Project: Sync
 */
class CreateGroupPage extends Page {
    public static String pinNumber;
    public static String GroupName;


    CreateGroupPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setId("pagethree");
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setVgap(5);

        // Build UI Components
        TextField groupNameTextField = new TextField();
        groupNameTextField.setPromptText("Group Name");

        Label createGroupLabel = new Label("Group Setup");
        createGroupLabel.setId("Bigtext");

        TextField pincodeTextField = new TextField();
        pincodeTextField.setPromptText("Pin Code (Optional)");


        Button createGroupButton = new Button("Create Group");
        createGroupButton.setOnAction(e -> {
            Label gname1= new Label();
            Label pcode1= new Label();
            String gname= groupNameTextField.getText();
            String pcode= pincodeTextField.getText();
            gname1.setText(gname);
            pcode1.setText(pcode);
            pinNumber = pcode;
            GroupName = gname;
            nextPage();
        });

        // Set location of components in GridPane
        GridPane.setConstraints(createGroupLabel, 0, 0);
        GridPane.setConstraints(groupNameTextField, 0, 1);
        GridPane.setConstraints(pincodeTextField, 0, 2);
        GridPane.setConstraints(createGroupButton, 0, 3);
        GridPane.setHalignment(createGroupLabel, HPos.CENTER);
        GridPane.setHalignment(createGroupButton, HPos.CENTER);

        // Add components into GridPane
        contentPane.getChildren().addAll(createGroupLabel, createGroupButton, groupNameTextField, pincodeTextField);
    }

    @Override
    public void nextPage() {
        Window.setScene(Window.PAGE.CREATE_PLAYLIST);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.OPTIONS);
    }


}
