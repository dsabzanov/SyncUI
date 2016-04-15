import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by davidsabzanov on 4/11/16.
 */
public class BTAnimationPage extends Page {
    public BTAnimationPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setId("Bluetooth");
        pane.setAlignment(Pos.CENTER);


        // Build UI Components
        Button backButton = new Button("Tap to Cancel");
        backButton.setOnAction(e -> prevPage());


        // Set location of components in GridPane
        GridPane.setConstraints(backButton, 16, 1293);



        // Add components into GridPane
        pane.getChildren().addAll(backButton);
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        primaryStage.setScene(new OptionsPage(primaryStage));
    }
}
