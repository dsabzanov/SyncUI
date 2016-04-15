package GUI.Pages;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by davidsabzanov on 4/11/16.
 * Project: Sync
 */
class SearchProgressPage extends Page {

    SearchProgressPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setAlignment(Pos.CENTER);

        Button backButton = new Button("Tap to Cancel");
        backButton.setOnAction(e -> prevPage());

        GridPane.setConstraints(backButton, 16, 1293);

        pane.getChildren().addAll(backButton);
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
