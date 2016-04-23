package GUI.Pages;
/**
 * Created by Mac on 4/13/16.
 * Project: Sync
 */

import GUI.DataWrappers.SongWrapper;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class HostListPage extends Page {

    public HostListPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setId("pagesix");
        contentPane.setAlignment(Pos.CENTER);

        // build UI components
        Button joinGroupButton = new Button("Join Group");
        joinGroupButton.setOnAction(e -> nextPage());
        GridPane.setHalignment(joinGroupButton, HPos.CENTER);


        TableColumn<SongWrapper, String> SongColumn = new TableColumn<>("Groups");
        SongColumn.setMinWidth(this.getWidth());
        SongColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<SongWrapper> GroupTable = new TableView<>();
        GroupTable.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        GroupTable.getColumns().add(SongColumn);

        // Arrange in GridPane
        GridPane.setConstraints(joinGroupButton, 0, 2);
        //GridPane.setConstraints(groupListLabel, 0, 0);
        GridPane.setConstraints(GroupTable, 0, 1);

        // Add to GridPane
        contentPane.getChildren().addAll( joinGroupButton, GroupTable);
    }

    @Override
    public void nextPage() {
        Window.setScene(Window.PAGE.LOADING);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.OPTIONS);
    }
}