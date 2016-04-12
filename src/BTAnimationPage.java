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
        pane.setAlignment(Pos.CENTER);

        Button backButton = new Button("Tap to Cancel");
        GridPane.setConstraints(backButton, 16, 43);
        backButton.setOnAction(e -> prevPage());

        pane.getChildren().addAll(backButton);
        pane.setId("Bluetooth");
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        primaryStage.hide();
        primaryStage.setScene(new OptionsPage(primaryStage));
        primaryStage.show();
    }
}
