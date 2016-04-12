import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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


    public CreatePlaylistPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setAlignment(Pos.CENTER);

        Button addMusicButton = new Button("Add Music");
        GridPane.setConstraints(addMusicButton, 1, 5);


        Label songListLabel = new Label(" Songs List");
        GridPane.setConstraints(songListLabel, 0, 0);
        songListLabel.setId("Bigtext");


        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 5);
        backButton.setOnAction(e -> prevPage());

        TableColumn<DisplaySongs4host, String> SongColumn = new TableColumn<>("Songs");
        SongColumn.setMinWidth(500);
        SongColumn.setCellValueFactory(new PropertyValueFactory<>("songName"));
        TableView<DisplaySongs4host> SongTable = new TableView<>();
        SongTable.setItems(getSong());
        SongTable.getColumns().addAll(SongColumn);
        GridPane.setConstraints(SongTable, 0, 2);

        //VBox vbox = new VBox();
        //vbpane.setSpacing(15);
        //vbox.setPadding(new Insets(200, 200, 200, 200));


        addMusicButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                //fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));   //Optional line of code to open file chooser at home directory
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("MP3 Files (.mp3)", "*.mp3"),
                        new FileChooser.ExtensionFilter("WAV Files (.wav)", "*.wav")
                );
                File file = fileChooser.showOpenDialog(primaryStage);
                String fileName = file.getName();
                SongTable.getItems().add(new DisplaySongs4host(fileName));
                System.out.println(fileName);
            }
        });



        pane.getChildren().addAll(songListLabel, addMusicButton, SongTable, backButton);
        pane.setId("pagesix");
        //scene4 = new Scene(vbox);

    }


    public ObservableList<DisplaySongs4host> getSong() {
        ObservableList<DisplaySongs4host> Songs = FXCollections.observableArrayList();
        return Songs;

    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        primaryStage.hide();
        primaryStage.setScene(new CreateGroupPage(primaryStage));
        primaryStage.show();
    }
}
