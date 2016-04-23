package GUI.Pages;

import GUI.DataWrappers.SongWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Button;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by davidsabzanov on 4/11/16.
 * Project: Sync
 */
class CreatePlaylistPage extends Page {

    private TableView<SongWrapper> SongTable = new TableView<>();
    public static String songN;//TableView Declared


    CreatePlaylistPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setId("pagesix");
        contentPane.setAlignment(Pos.TOP_CENTER);  //Alignment of GridPane set to CENTER

        //Add Music button
        Button addMusicButton = new Button("+");
        // Display brief details about what the button do.
        addMusicButton.setTooltip(new Tooltip("Add a new song to the list"));
        addMusicButton.setId("addMusicButton");
/*

        // Group Name label
        Label GroupL = new Label("Group Name: " + CreateGroupPage.GroupName);
        GroupL.setId("pagethree");

*/

        //Delete Music button
        Button deleteMusicButton = new Button("-");
        deleteMusicButton.setTooltip(new Tooltip("Delete a song from the list"));
        deleteMusicButton.setOnAction(e -> deleteSong());
        deleteMusicButton.setId("deleteMusicButton");

        //HBox for Adding and Deleting music
        HBox actionButtons = new HBox(17);

        //Start Button
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> nextPage());

        //Table Column
        TableColumn<SongWrapper, String> SongColumn = new TableColumn<>(CreateGroupPage.GroupName + " - Playlist");
        SongColumn.setMinWidth(this.getWidth());
        SongColumn.setCellValueFactory(new PropertyValueFactory<>("songName"));
        SongColumn.setResizable(false);

        //Table View
        SongTable.setMinWidth(this.getWidth());
        SongTable.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        SongTable.getColumns().add(SongColumn);
        SongTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //Create Row Mouse Click Event
        SongTable.setRowFactory(e -> createRowFactory());

        //Handle Button press
        addMusicButton.setOnAction(event -> addMusic());

        //Arrange UI components
        GridPane.setConstraints(SongTable, 0, 1);
        GridPane.setConstraints(startButton, 0, 2);
        GridPane.setHalignment(startButton, HPos.CENTER);
        GridPane.setValignment(startButton, VPos.CENTER);
        actionButtons.setAlignment(Pos.CENTER_RIGHT);
        contentPane.getChildren().addAll(actionButtons, SongTable,startButton);
        actionButtons.getChildren().addAll(addMusicButton, deleteMusicButton);
        universalToolbar.getChildren().addAll(actionButtons);
    }

    private TableRow<SongWrapper> createRowFactory() {
        TableRow<SongWrapper> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && (!row.isEmpty())) {
                SongWrapper rowData = row.getItem();
                System.out.println("Selected Song Name: " + rowData.getSongName());
                System.out.println("Selected Song Path: " + rowData.getFilePath());
                songN= rowData.getSongName();
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
            songN= file.getName();
            System.out.println("Song Added: " + file.getName());
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
        Window.setScene(Window.PAGE.SERVER_PLAYER);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.CREATE_GROUP);
    }
}
