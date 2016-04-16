package GUI.Pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by gregl on 4/11/2016.
 * Project: Sync
 */
abstract class Page extends Scene {
    private static final String CSS_STYLE = Page.class.getResource("../Styles/style.css").toExternalForm();
    BorderPane pageContainer; // Main Container that holds entire page together
    GridPane contentPane = new GridPane(); // Holds Page specific content, all pages should only modify this
    HBox universalToolbar = new HBox(); // Holds the back button and anything else a page may want on top
    Stage primaryStage;

    Page(Stage primaryStage) {
        super(new BorderPane(), 400, 500);
        pageContainer = (BorderPane) this.getRoot();

        buildUniversalToolbar();

        pageContainer.setMinWidth(this.getWidth());
        pageContainer.setMinHeight(this.getHeight());


        pageContainer.setTop(universalToolbar);
        pageContainer.setCenter(contentPane);


        this.primaryStage = primaryStage;
        this.getStylesheets().add(CSS_STYLE);
        contentPane.setGridLinesVisible(true);
    }

    private void buildUniversalToolbar() {
        Button backButton = new Button("<-");
        backButton.setOnAction(e -> prevPage());
        universalToolbar.getChildren().add(backButton);
    }

    public abstract void nextPage();

    public abstract void prevPage();

}
