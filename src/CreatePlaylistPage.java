import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by davidsabzanov on 4/11/16.
 */
public class CreatePlaylistPage extends Page {

    private TableView<DisplaySongs4host> SongTable = new TableView<>(); //TableView Declared

    public CreatePlaylistPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setAlignment(Pos.CENTER);  //Alignment of GridPane set to CENTER


        //Song List label
        Label songListLabel = new Label(" Songs List");
        GridPane.setConstraints(songListLabel, 0, 0);
        songListLabel.setId("Bigtext");


        //Add Music button
        Button addMusicButton = new Button("Add Music");
        GridPane.setConstraints(addMusicButton, 1, 0);


        //Delete Music button
        Button deleteMusicButton = new Button("Delete Song");
        GridPane.setConstraints(deleteMusicButton, 1, 5);
        deleteMusicButton.setOnAction(e -> deleteSong());


        //Back button
        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 5);
        backButton.setOnAction(e -> prevPage());


        //Table Column
        TableColumn<DisplaySongs4host, String> SongColumn = new TableColumn<>("Songs");
        SongColumn.setMinWidth(500);
        SongColumn.setCellValueFactory(new PropertyValueFactory<>("songName"));


        //Table View
        SongTable.setItems(getSong());
        SongTable.getColumns().add(SongColumn);
        GridPane.setConstraints(SongTable, 0, 2);


        //Row Mouse Click Event
        SongTable.setRowFactory(e -> {
            TableRow<DisplaySongs4host> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty())) {
                    DisplaySongs4host rowData = row.getItem();
                    System.out.println("Selected: " + rowData.getSongName());
                }
            });
            return row;
        });





        addMusicButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                //fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));   //Optional line of code to open file chooser at home directory
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("MP3 Files (.mp3)", "*.mp3"),
                        new FileChooser.ExtensionFilter("WAV Files (.wav)", "*.wav")
                );
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    String fileName = file.getName();
                    String filePath = file.getAbsolutePath();
                    SongTable.getItems().add(new DisplaySongs4host(fileName, filePath));
                    System.out.println("Added: " + fileName);
                }
            }
        });



        pane.getChildren().addAll(songListLabel, addMusicButton, SongTable, backButton, deleteMusicButton);
        pane.setId("pagesix");
    }


    public ObservableList<DisplaySongs4host> getSong() {
        ObservableList<DisplaySongs4host> Songs = FXCollections.observableArrayList();
        return Songs;
    }


    //Delete Song Method
    public void deleteSong() {
        ObservableList<DisplaySongs4host> selectedSong, allSongs;
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
