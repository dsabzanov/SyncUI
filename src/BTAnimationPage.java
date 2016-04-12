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
        pane.setAlignment(Pos.BASELINE_LEFT);

        Button back1 = new Button("Tap to Cancel");
        GridPane.setConstraints(back1, 16, 43);
        back1.setOnAction(e -> prevPage());
        pane.getChildren().addAll(back1);
        pane.setId("Bluetooth");
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        primaryStage.setScene(new OptionsPage(primaryStage));
    }
}
