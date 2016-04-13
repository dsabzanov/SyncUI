import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by davidsabzanov on 4/11/16.
 */
class MainPage extends Page {

    public MainPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setAlignment(Pos.CENTER);

        Label label1 = new Label("Welcome to SYNC");
        Label label2 = new Label(" Bluetooth Name: ");
        label1.setId("Bigtext");
        label2.setId("pagefour");
        GridPane.setConstraints(label2, 0, 3);
        GridPane.setConstraints(label1, 1, 0);
        //name
        TextField nameinput = new TextField();
        String s = nameinput.getText();
        GridPane.setConstraints(nameinput, 1, 3);
        Button loginBtn = new Button(" Login ");
        GridPane.setConstraints(loginBtn, 2, 5);
        loginBtn.setOnAction(e -> nextPage());
        pane.setId("mainpage");
        pane.getChildren().addAll(label1, label2, nameinput, loginBtn);
    }

    @Override
    public void nextPage() {
        primaryStage.setScene(new OptionsPage(primaryStage));
    }

    @Override
    public void prevPage() {

    }
}
