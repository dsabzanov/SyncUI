package GUI.Pages;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Created by davidsabzanov on 4/11/16.
 * Project: Sync
 */
class OptionsPage extends Page {

    OptionsPage() {
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setId("pagetwo");
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setPadding(new Insets(25, 25, 25, 25));
        contentPane.setVgap(8);
        contentPane.setHgap(10);

        // Build UI Components
        Button createAGroupButton = new Button("Start a Group");
        createAGroupButton.setId("btnLogin1");
        createAGroupButton.setOnAction(e -> Window.setScene(Window.PAGE.CREATE_GROUP));

        Button joinAGroupButton = new Button("Join a Group ");
        joinAGroupButton.setId("btnLogin1");
        joinAGroupButton.setOnAction(e -> Window.setScene(Window.PAGE.SEARCH_PROGRESS));

        // Set location of components in GridPane
        GridPane.setConstraints(createAGroupButton, 0, 0);
        GridPane.setConstraints(joinAGroupButton, 0, 1);

        // Add components into GridPane
        contentPane.getChildren().addAll(createAGroupButton, joinAGroupButton);
    }

    @Override
    public void nextPage() {
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.MAIN);
    }
}
