package GUI.Pages;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by gregl on 4/11/2016.
 * Project: Sync
 */
abstract class Page extends Scene {
    private static final String CSS_STYLE = Page.class.getResource("../Styles/style.css").toExternalForm();
    GridPane pane;
    Stage primaryStage;

    Page(Stage primaryStage) {
        super(new GridPane(), 700, 800);
        pane = (GridPane) this.getRoot();
        this.primaryStage = primaryStage;
        this.getStylesheets().add(CSS_STYLE);
        pane.setGridLinesVisible(true);
    }

    public abstract void nextPage();

    public abstract void prevPage();

}
