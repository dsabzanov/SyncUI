import javafx.geometry.Pos;
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
        pane.setVgap(8);

        System.out.println("");
        Label label5 = new Label("Create A Group");
        GridPane.setConstraints(label5, 0, 10);
        label5.setId("pagefour");
        Button back1 = new Button("Back");
        GridPane.setConstraints(back1, 0, 70);
        back1.setOnAction(e -> prevPage());
        Label label3 = new Label(" Group Name: ");
        GridPane.setConstraints(label3, 0, 15);
        label3.setId("pagefour");
        //name
        TextField GName = new TextField();
        GridPane.setConstraints(GName, 1, 15);
        // pincode label
        Label label4 = new Label(" Pincode: ");
        GridPane.setConstraints(label4, 0, 19);
        label4.setId("pagefour");
        // text box
        TextField GName2 = new TextField();
        GName2.setPromptText("Optional");
        GridPane.setConstraints(GName2, 1, 19);
        Button CreateGroup = new Button(" Add Music ");
        GridPane.setConstraints(CreateGroup, 20, 20);
        CreateGroup.setOnAction(e -> nextPage());
        //Layout3
        pane.getChildren().addAll(back1, label3, label4, label5, CreateGroup, GName, GName2);
        pane.setId("pagethree");
    }

    @Override
    public void nextPage() {
        primaryStage.setScene(new CreatePlaylistPage(primaryStage));
    }

    @Override
    public void prevPage() {
        primaryStage.setScene(new OptionsPage(primaryStage));
    }
}
