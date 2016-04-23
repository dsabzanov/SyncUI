package GUI.Pages;

import GUI.Resources.Resources;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by davidsabzanov on 4/22/16.
 */
public class LoadingPage extends Page {

    LoadingPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setId("root");



        //Set background
        ImageView background = Resources.getInstance().getImageView("loading2");
        contentPane.getChildren().add(background);

        //Pause and move to next page
        PauseTransition trans = new PauseTransition(Duration.seconds(6));
        trans.setOnFinished(e -> nextPage());
        trans.play();

    }


    @Override
    public void nextPage() {
        Window.setScene(Window.PAGE.PINCODE);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.HOSTLIST);
    }
}
