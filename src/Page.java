import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by gregl on 4/11/2016.
 */
abstract public class Page extends Scene {
    private GridPane pane;
    protected Stage primaryStage;

    public Page(Stage primaryStage) {
        super(new GridPane(), 900, 900);
        pane = (GridPane) this.getRoot();
        this.primaryStage = primaryStage;
    }

    public abstract void nextPage();

    public abstract void prevPage();

}
