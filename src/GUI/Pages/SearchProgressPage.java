package GUI.Pages;

import GUI.Resources.Resources;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by davidsabzanov on 4/11/16.
 * Project: Sync
 */
class SearchProgressPage extends Page {

    SearchProgressPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setId("Bluetooth");
        ImageView background = Resources.getInstance().getImageView("searching");
        contentPane.getChildren().add(background);
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.OPTIONS);
    }
}
