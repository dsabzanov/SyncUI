package GUI.Pages;

import GUI.DataWrappers.SongWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

    CreatePlaylistPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setId("pagesix");
        contentPane.setAlignment(Pos.TOP_CENTER);  //Alignment of GridPane set to CENTER

        //Add Music button
        Button addMusicButton = new Button("+");

        //Delete Music button
        Button deleteMusicButton = new Button("-");
        deleteMusicButton.setOnAction(e -> deleteSong());

        //Start Button
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> nextPage());

        //Table Column
        TableColumn<SongWrapper, String> SongColumn = new TableColumn<>("Library");
        SongColumn.setMinWidth(contentPane.getWidth());
        SongColumn.setCellValueFactory(new PropertyValueFactory<>("songName"));

        //Table View
        SongTable.setMinWidth(this.getWidth());
        SongTable.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        SongTable.getColumns().add(SongColumn);

        //Create Row Mouse Click Event
        SongTable.setRowFactory(e -> createRowFactory());

        //Handle Button press
        addMusicButton.setOnAction(event -> addMusic());

        //Arrange UI components
        GridPane.setConstraints(SongTable, 0, 1);
        GridPane.setConstraints(startButton, 0, 2);
        GridPane.setHalignment(startButton, HPos.RIGHT);
        contentPane.getChildren().addAll(SongTable,startButton);
        universalToolbar.getChildren().addAll(addMusicButton, deleteMusicButton);
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
        File file = fileChooser.showOpenDialog(null);
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
        Window.setScene(Window.PAGE.PLAYER);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.CREATEGROUP);
    }
}
