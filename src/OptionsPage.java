import javafx.geometry.Pos;
import javafx.geometry.Insets;
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
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setVgap(10);
        pane.setHgap(10);



        Button createAGroupButton = new Button(" Create A Group");
        GridPane.setConstraints(createAGroupButton, 0, 0);

        createAGroupButton.setOnAction(e -> {
            primaryStage.hide();
            primaryStage.setScene(new CreateGroupPage(primaryStage));
            primaryStage.show();
        });




        Button joinAGroupButton = new Button(" Join A Group");
        GridPane.setConstraints(joinAGroupButton, 0, 1);

        joinAGroupButton.setOnAction(e -> {
            primaryStage.hide();
            primaryStage.setScene(new BTAnimationPage(primaryStage));
            primaryStage.show();
        });




        pane.getChildren().addAll(createAGroupButton, joinAGroupButton);
        pane.setId("pagetwo");
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {

    }
}
