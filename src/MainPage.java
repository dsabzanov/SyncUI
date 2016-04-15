import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by davidsabzanov on 4/11/16.
 */
public class MainPage extends Page {

    public MainPage(Stage primaryStage) {
        super(primaryStage);
        buildUI();
    }

    private void buildUI() {
        pane.setId("mainpage");
        pane.setAlignment(Pos.CENTER);

        // Build UI Components
        Label welcomeLabel = new Label("Welcome to SYNC");
        welcomeLabel.setId("Bigtext");

        Label bluetoothNameLabel = new Label(" Bluetooth Name: ");
        bluetoothNameLabel.setId("pagefour");

        TextField bluetoothNameTextField = new TextField();
        String s = bluetoothNameTextField.getText();

        Button loginButton = new Button(" Login ");
        loginButton.setOnAction(e -> nextPage());


        // Set location of components in GridPane
        GridPane.setConstraints(bluetoothNameLabel, 0, 3);

        GridPane.setConstraints(welcomeLabel, 1, 0);

        GridPane.setConstraints(bluetoothNameTextField, 1, 3);

        GridPane.setConstraints(loginButton, 2, 5);


        // Add components into GridPane
        pane.getChildren().addAll(welcomeLabel, bluetoothNameLabel, bluetoothNameTextField, loginButton);
    }

    @Override
    public void nextPage() {
        primaryStage.setScene(new OptionsPage(primaryStage));
    }

    @Override
    public void prevPage() {

    }
}
