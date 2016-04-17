package GUI.Pages;

import GUI.Resources.Resources;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Created by gregl on 4/15/2016.
 * Project: Sync
 */
public class PlayerPage extends Page {
    private int playPauseIndex = 0;

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
        pinLabel.setId("Bigtext");

        //Load and Resize Cover art image to fit boundry
        ImageView coverArt = Resources.getInstance().getImageView("defaultCoverArt");
        coverArt.setPreserveRatio(false);
        coverArt.setFitHeight(this.getWidth() - 20);
        coverArt.setFitWidth(this.getWidth()); // shrink to fit window


        //Progress bar for audio
        StackPane progress = new StackPane();
        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setMinWidth(this.getWidth());
        progressBar.setId("progressBar");
        Slider progressSlider = new Slider();
        progressSlider.setMinWidth(this.getWidth());
        progressSlider.valueProperty().addListener((observable, oldValue, newValue) ->
                progressBar.setProgress(newValue.doubleValue() / 100)
        );
        StackPane.setAlignment(progressBar, Pos.TOP_CENTER);
        StackPane.setAlignment(progressSlider, Pos.CENTER);
        progress.getChildren().addAll(progressBar, progressSlider);

        //Box to hold all player controls horizontally
        HBox controlContainer = new HBox();
        controlContainer.setAlignment(Pos.CENTER);

        //Create playback buttons
        Button prevButton = new Button();
        Button rewindButton = new Button();
        Button playButton = new Button();
        Button ffButton = new Button();
        Button nextButton = new Button();

        //Add images to buttons
        //Used to cycle through images
        ImageView playPauseImages[] = new ImageView[2];
        playPauseImages[0] = Resources.getInstance().getImageView("playButton");
        playPauseImages[1] = Resources.getInstance().getImageView("pauseButton");
        prevButton.setGraphic(Resources.getInstance().getImageView("prevButton"));
        rewindButton.setGraphic(Resources.getInstance().getImageView("rewButton"));
        playButton.setGraphic(playPauseImages[0]);
        ffButton.setGraphic(Resources.getInstance().getImageView("ffButton"));
        nextButton.setGraphic(Resources.getInstance().getImageView("nextButton"));

        //Add functionality to buttons
        prevButton.setOnAction(e -> previous());
        rewindButton.setOnAction(e -> rewind());
        playButton.setOnAction(e -> {
            if (playPauseIndex++ == 0)
                play();
            else
                pause();
            playPauseIndex %= 2;
            playButton.setGraphic(playPauseImages[playPauseIndex]);
        });
        ffButton.setOnAction(e -> fastForward());
        nextButton.setOnAction(e -> next());

        //Add playback buttons to container
        controlContainer.getChildren().addAll(prevButton, rewindButton, playButton, ffButton, nextButton);
        componentContainer.getChildren().addAll(coverArt, progress, controlContainer);

        //Add Pinlabel to Universal toolbar
        universalToolbar.getChildren().add(pinLabel);

        //Set button style for controls
        controlContainer.getChildren().forEach(e -> {
            Button btn = (Button) e;
            ImageView image = (ImageView) btn.getGraphic();
            btn.setId("playerButton");
            image.setFitWidth(27);
        });
        playPauseImages[1].setFitWidth(27);

        //Add containers to Gridpane
        contentPane.getChildren().add(componentContainer);

        //Set locations on gridpane
        GridPane.setConstraints(componentContainer, 0, 0);
    }

    private void play() {
        System.out.println("Play");

    }

    private void pause() {
        System.out.println("Pause");
    }

    private void fastForward() {
        System.out.println("Fast Forward");
    }

    private void rewind() {
        System.out.println("Rewind");
    }

    private void previous() {
        System.out.println("Previous");
    }

    private void next() {
        System.out.println("Next");
    }

    @Override
    public void nextPage() {
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.CREATEPLAYLIST);
    }
}
