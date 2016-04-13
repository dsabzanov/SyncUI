import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by gregl on 4/11/2016.
 */
abstract public class Page extends Scene {
    protected static final String CSS_STYLE = Page.class.getResource("style.css").toExternalForm();
    protected GridPane pane;
    protected Stage primaryStage;

    public Page(Stage primaryStage) {
        super(new GridPane(), 800, 700);
        pane = (GridPane) this.getRoot();
        this.primaryStage = primaryStage;
        this.getStylesheets().add(CSS_STYLE);
        pane.setGridLinesVisible(true);
        //pane.setPadding(new Insets(25, 25, 25, 25));
        //pane.setVgap(10);
        //pane.setHgap(10);
    }

    public abstract void nextPage();

    public abstract void prevPage();

}
