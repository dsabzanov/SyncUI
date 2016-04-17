package GUI.Pages;

import javafx.geometry.Insets;
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
    HBox universalToolbar = new HBox(10); // Holds the back button and anything else a page may want on top

    Page() {
        super(new BorderPane(), Window.WIDTH, Window.HEIGHT);
        pageContainer = (BorderPane) this.getRoot();

        buildUniversalToolbar();

        pageContainer.setMinWidth(this.getWidth());
        pageContainer.setMinHeight(this.getHeight());

        contentPane.setMinWidth(this.getWidth());
        pageContainer.setTop(universalToolbar);
        pageContainer.setCenter(contentPane);
        //BorderPane.setMargin(contentPane, new Insets(24, 0, 0, 0));
        this.getStylesheets().add(CSS_STYLE);
    }

    private void buildUniversalToolbar() {
        Button backButton = new Button("<-");
        backButton.setOnAction(e -> prevPage());
        universalToolbar.getChildren().add(backButton);
    }

    public abstract void nextPage();

    public abstract void prevPage();

}
