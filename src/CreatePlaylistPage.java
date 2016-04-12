import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
        Button addmusic = new Button("Add Music");
        GridPane.setConstraints(addmusic, 0, 20);
        //addmusic.setOnAction(e -> System.out.println(" Greg this is where it should request your code to add music"));


        addmusic.setOnAction(new EventHandler<ActionEvent>(){
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
                System.out.println(fileName);
            }
        });





        Label label5 = new Label(" Songs List");
        label5.setId("Bigtext");
        GridPane.setConstraints(label5, 3, 1);
        Button back1 = new Button("Back");
        GridPane.setConstraints(back1, 0, 80);
        back1.setOnAction(e -> prevPage());

        TableColumn<DisplaySongs4host, String> SongC = new TableColumn<>("Songs");
        SongC.setMinWidth(500);
        SongC.setCellValueFactory(new PropertyValueFactory<>("songName"));
        back1 = new Button("Back");
        GridPane.setConstraints(back1, 0, 80);
        back1.setOnAction(e -> prevPage());
        TableView<DisplaySongs4host> Songtable = new TableView<>();
        Songtable.setItems(getSong());
        Songtable.getColumns().addAll(SongC);
        GridPane.setConstraints(Songtable, 1, 15);
        VBox vbox = new VBox();
        vbox.setSpacing(15);
        vbox.setPadding(new Insets(200, 200, 200, 200));
        vbox.getChildren().addAll(label5, addmusic, Songtable, back1);
        vbox.setId("pagesix");
        scene4 = new Scene(vbox);
    }


    public ObservableList<DisplaySongs4host> getSong() {
        ObservableList<DisplaySongs4host> Songs = FXCollections.observableArrayList();
        Songs.add(new DisplaySongs4host("I hate Exams"));
        Songs.add(new DisplaySongs4host("I "));
        Songs.add(new DisplaySongs4host("Exams"));
        Songs.add(new DisplaySongs4host("hate "));
        return Songs;

    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        primaryStage.setScene(new CreateGroupPage(primaryStage));
    }
}
