
/**
 * Created by Mac on 4/13/16.
 */
import javafx.collections.FXCollections;
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

public class HostListPage extends Page {

    private TableView<DisplayHosts4Client> HostsTable = new TableView<>(); //TableView Declared

    public HostListPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setId("pagesix");
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);



        // Build UI Components
        Label songListLabel = new Label(" Hosts List");
        songListLabel.setId("Bigtext");

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> prevPage());


        TableColumn<DisplayHosts4Client, String> HostColumn = new TableColumn<>("Hosts");
        HostColumn.setMinWidth(500);
        HostColumn.setCellValueFactory(new PropertyValueFactory<>("hostName"));

        HostsTable.setItems(getHost());
        HostsTable.getColumns().addAll(HostColumn);



        //Row Mouse Click Event
        HostsTable.setRowFactory(e -> {
            TableRow<DisplayHosts4Client> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty())) {
                    DisplayHosts4Client rowData = row.getItem();
                    System.out.println("Selected: " + rowData.getHostName());
                }
            });
            return row;
        });





        // Set location of components in GridPane
        GridPane.setConstraints(songListLabel, 0, 0);

        GridPane.setConstraints(backButton, 0, 2);

        GridPane.setConstraints(HostsTable, 0, 1);




        // Add components into GridPane
        pane.getChildren().addAll(songListLabel, HostsTable, backButton);
    }

    public ObservableList<DisplayHosts4Client> getHost() {
        ObservableList<DisplayHosts4Client> Hosts = FXCollections.observableArrayList();
        return Hosts;
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void prevPage() {
        primaryStage.setScene(new OptionsPage(primaryStage));
    }
}