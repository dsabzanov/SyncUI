package GUI.Pages;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by gregl on 4/15/2016.
 * Project: Sync
 */
public class PlayerPage extends Page {
    String coverArtURL = Page.class.getResource("../Images/defaultCoverArt.png").toString();

    PlayerPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setAlignment(Pos.TOP_CENTER);

        //Box to hold all elements vertically
        VBox componentContainer = new VBox();

        //Label to display pin number
        Label pinLabel = new Label("PIN: 1234");

        //ImageView to show Cover art
        ImageView coverArt = new ImageView(coverArtURL);
        coverArt.setPreserveRatio(true);
        coverArt.setFitWidth(this.getWidth());

        //Progress bar for audio
        ProgressBar progressBar = new ProgressBar(100);
        progressBar.setMinWidth(this.getWidth());

        //Box to hold all player controls horizontally
        HBox controlContainer = new HBox();
        controlContainer.setAlignment(Pos.CENTER);

        //Create playback buttons
        Button rewindButton = new Button("RR");
        Button playButton = new Button("Play");
        Button forwardButton = new Button("FF");

        //Add playback buttons to container
        controlContainer.getChildren().addAll(rewindButton, playButton, forwardButton);
        componentContainer.getChildren().addAll(pinLabel, coverArt, progressBar, controlContainer);
        contentPane.getChildren().add(componentContainer);
    }

    @Override
    public void nextPage() {
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.CREATEPLAYLIST);
    }
}
