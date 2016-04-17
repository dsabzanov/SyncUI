package GUI.Pages;

import GUI.Resources.Resources;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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

        //Set background
        ImageView background = Resources.getInstance().getImageView("searching");
        contentPane.getChildren().add(background);

        //Pause and move to next page
        PauseTransition trans = new PauseTransition(Duration.seconds(3));
        trans.setOnFinished(e -> nextPage());
        trans.play();
    }

    @Override
    public void nextPage() {
        Window.setScene(Window.PAGE.CLIENT_PLAYER);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.OPTIONS);
    }
}
