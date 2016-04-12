import javafx.geometry.Pos;
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

        Button button = new Button();
        GridPane.setConstraints(button, 1, 1);
        Button button1 = new Button(" Join A Group");
        button1.setOnAction(e -> primaryStage.setScene(scene6));
        GridPane.setConstraints(button1, 1, 2);
        button.setText(" Create A Group");// page 3 go here which contains how to create a group and start hosting.
        button.setOnAction(e -> primaryStage.setScene(scene3));
        pane.getChildren().addAll(button, button1);
        pane.setId("pagetwo");


    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {

    }
}
