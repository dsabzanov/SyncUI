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
        pane.setId("pagethree");
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);
        //pane.setPadding(new Insets(25, 25, 25, 25));
        //pane.setHgap(10);

        // Build UI Components
        Label createGroupLabel = new Label("Create A Group");
        createGroupLabel.setId("pagefour");

        Label groupNameLabel = new Label(" Group Name: ");
        groupNameLabel.setId("pagefour");

        TextField groupNameTextField = new TextField();

        Label pincodeLabel = new Label(" Pincode: ");
        pincodeLabel.setId("pagefour");

        TextField pincodeTextField = new TextField();
        pincodeTextField.setPromptText("Optional");

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> prevPage());

        Button addMusicButton = new Button(" Add Music ");
        addMusicButton.setOnAction(e -> nextPage());

        // Set location of components in GridPane
        GridPane.setConstraints(createGroupLabel, 0, 0);

        GridPane.setConstraints(groupNameLabel, 0, 1);
        GridPane.setConstraints(groupNameTextField, 1, 1);

        GridPane.setConstraints(pincodeLabel, 0, 2);
        GridPane.setConstraints(pincodeTextField, 1, 2);

        GridPane.setConstraints(backButton, 0, 3);
        GridPane.setConstraints(addMusicButton, 3, 3);

        // Add components into GridPane
        pane.getChildren().addAll(backButton, groupNameLabel, pincodeLabel, createGroupLabel, addMusicButton, groupNameTextField, pincodeTextField);
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
