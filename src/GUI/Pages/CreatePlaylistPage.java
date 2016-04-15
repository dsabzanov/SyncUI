package GUI.Pages;

import GUI.DataWrappers.SongWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by davidsabzanov on 4/11/16.
 * Project: Sync
 */
class CreatePlaylistPage extends Page {

    private TableView<SongWrapper> SongTable = new TableView<>(); //TableView Declared

    CreatePlaylistPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setId("pagesix");
        pane.setAlignment(Pos.CENTER);  //Alignment of GridPane set to CENTER

        //Song List label
        Label songListLabel = new Label(" Songs List");
        songListLabel.setId("Bigtext");

        //Add Music button
        Button addMusicButton = new Button("Add Music");

        //Delete Music button
        Button deleteMusicButton = new Button("Delete Song");
        deleteMusicButton.setOnAction(e -> deleteSong());

        //Back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> prevPage());

        //Table Column
        TableColumn<SongWrapper, String> SongColumn = new TableColumn<>("Songs");
        SongColumn.setMinWidth(500);
        SongColumn.setCellValueFactory(new PropertyValueFactory<>("songName"));

        //Table View
        SongTable.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        SongTable.getColumns().add(SongColumn);

        //Create Row Mouse Click Event
        SongTable.setRowFactory(e -> createRowFactory());

        //Handle Button press
        addMusicButton.setOnAction(event -> addMusic());

        //Arrange UI components
        GridPane.setConstraints(songListLabel, 0, 0);
        GridPane.setConstraints(addMusicButton, 1, 0);
        GridPane.setConstraints(deleteMusicButton, 1, 5);
        GridPane.setConstraints(backButton, 0, 5);
        GridPane.setConstraints(SongTable, 0, 2);

        pane.getChildren().addAll(songListLabel, addMusicButton, SongTable, backButton, deleteMusicButton);
    }

    private TableRow<SongWrapper> createRowFactory() {
        TableRow<SongWrapper> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                SongWrapper rowData = row.getItem();
                System.out.println("Selected: " + rowData.getSongName());
            }
        });
        return row;
    }

    private void addMusic() {
        FileChooser fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));   //Optional line of code to open file chooser at home directory
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("MP3 Files (.mp3)", "*.mp3"),
                new FileChooser.ExtensionFilter("WAV Files (.wav)", "*.wav")
        );
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            SongTable.getItems().add(new SongWrapper(file));
            System.out.println("Added: " + file.getName());
        }
    }

    //Delete Song Method
    private void deleteSong() {
        ObservableList<SongWrapper> selectedSong, allSongs;
        allSongs = SongTable.getItems();
        selectedSong = SongTable.getSelectionModel().getSelectedItems();
        selectedSong.forEach(allSongs::remove);
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        primaryStage.setScene(new CreateGroupPage(primaryStage));
    }
}
