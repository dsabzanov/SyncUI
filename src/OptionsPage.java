import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by davidsabzanov on 4/11/16.
 */
public class OptionsPage extends Page {


    public OptionsPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();

    }


    private void buildUI() {
        pane.setId("pagetwo");
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setVgap(8);
        pane.setHgap(10);


        // Build UI Components
        Button createAGroupButton = new Button(" Create A Group");
        createAGroupButton.setOnAction(e -> {
            primaryStage.setScene(new CreateGroupPage(primaryStage));
        });


        Button joinAGroupButton = new Button(" Join A Group");
        joinAGroupButton.setOnAction(e -> {
            primaryStage.setScene(new BTAnimationPage(primaryStage));
        });



        // Set location of components in GridPane
        GridPane.setConstraints(createAGroupButton, 0, 0);

        GridPane.setConstraints(joinAGroupButton, 0, 1);


        // Add components into GridPane
        pane.getChildren().addAll(createAGroupButton, joinAGroupButton);
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {

    }
}
