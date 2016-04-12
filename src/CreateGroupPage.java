import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by davidsabzanov on 4/11/16.
 */
public class CreateGroupPage extends Page {

    public CreateGroupPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setAlignment(Pos.CENTER);
        //pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setVgap(5);
        //pane.setHgap(10);

        Label createGroupLabel = new Label("Create A Group");
        GridPane.setConstraints(createGroupLabel, 0, 0);
        createGroupLabel.setId("pagefour");
        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 3);
        backButton.setOnAction(e -> prevPage());

        Label groupNameLabel = new Label(" Group Name: ");
        GridPane.setConstraints(groupNameLabel, 0, 1);
        groupNameLabel.setId("pagefour");

        //name
        TextField groupNameTextField = new TextField();
        GridPane.setConstraints(groupNameTextField, 1, 1);
        // pincode label
        Label pincodeLabel = new Label(" Pincode: ");
        GridPane.setConstraints(pincodeLabel, 0, 2);
        pincodeLabel.setId("pagefour");
        // text box
        TextField pincodeTextField = new TextField();
        pincodeTextField.setPromptText("Optional");
        GridPane.setConstraints(pincodeTextField, 1, 2);
        Button addMusicButton = new Button(" Add Music ");
        GridPane.setConstraints(addMusicButton, 3, 3);
        addMusicButton.setOnAction(e -> nextPage());
        //Layout3
        pane.getChildren().addAll(backButton, groupNameLabel, pincodeLabel, createGroupLabel, addMusicButton, groupNameTextField, pincodeTextField);
        pane.setId("pagethree");
    }

    @Override
    public void nextPage() {
        primaryStage.hide();
        primaryStage.setScene(new CreatePlaylistPage(primaryStage));
        primaryStage.show();
    }

    @Override
    public void prevPage() {
        primaryStage.hide();
        primaryStage.setScene(new OptionsPage(primaryStage));
        primaryStage.show();
    }
}
