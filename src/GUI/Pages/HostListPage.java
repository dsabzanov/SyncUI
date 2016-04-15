package GUI.Pages;
/**
 * Created by Mac on 4/13/16.
 * Project: Sync
 */

import GUI.DataWrappers.SongWrapper;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HostListPage extends Page {

    public HostListPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setId("pagesix");
        pane.setAlignment(Pos.CENTER);

        // build UI components
        Button addMusicButton = new Button("Add Music");

        Label songListLabel = new Label(" Songs List");
        songListLabel.setId("Bigtext");

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> prevPage());

        TableColumn<SongWrapper, String> SongColumn = new TableColumn<>("Songs");
        SongColumn.setMinWidth(500);
        SongColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<SongWrapper> SongTable = new TableView<>();
        SongTable.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        SongTable.getColumns().add(SongColumn);

        // Arrange in GridPane
        GridPane.setConstraints(addMusicButton, 1, 5);
        GridPane.setConstraints(songListLabel, 0, 0);
        GridPane.setConstraints(backButton, 0, 5);
        GridPane.setConstraints(SongTable, 0, 2);

        // Add to GridPane
        pane.getChildren().addAll(songListLabel, addMusicButton, SongTable, backButton);
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        primaryStage.setScene(new CreateGroupPage(primaryStage));
    }
}