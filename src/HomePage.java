/**
 * Created by Mac on 3/16/16.
 */

import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.lang.String;


public class HomePage extends Application {

    Button button;
    Button back1;
    Button button1;
    Button CreateGroup;
    Button StartPage, addmusic;
    Button ViewSong;
    Scene scene1, scene2, scene3, scene4, scene5, scene6;
    TableView<DisplaySongs4host> Songtable;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sync 1.0");

        /*
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(8);
        */

        /*
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setPadding(new Insets(25, 25, 25, 25));
        grid2.setVgap(10);
        grid2.setHgap(10);
        */

        /*GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setPadding(new Insets(25, 25, 25, 25));
        grid3.setVgap(8);
        grid3.setHgap(10);

        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.TOP_LEFT);
        grid4.setPadding(new Insets(25, 25, 25, 25));
        grid4.setVgap(8);
        grid4.setHgap(10);

        GridPane grid5 = new GridPane();
        grid5.setAlignment(Pos.BASELINE_LEFT);
        grid5.setPadding(new Insets(25, 25, 25, 25));
        grid5.setVgap(8);
        grid5.setHgap(10);

        GridPane grid6 = new GridPane();
        grid6.setAlignment(Pos.BASELINE_LEFT);
        grid6.setPadding(new Insets(25, 25, 25, 25));
        grid6.setVgap(8);
        grid6.setHgap(10);*/

// Main page

/*
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
        StartPage = new Button(" Login ");
        GridPane.setConstraints(StartPage, 2, 5);
        StartPage.setOnAction(e -> primaryStage.setScene(scene2));

        //Layout1
        grid.setId("mainpage");
        grid.getChildren().addAll(label1, label2, nameinput, StartPage);
        scene1 = new Scene(grid, 900, 900);
        scene1.getStylesheets().add(HomePage.class.getResource("style.css").toExternalForm());
*/

// Next page

        /*
        button = new Button();
        GridPane.setConstraints(button, 1, 1);
        button1 = new Button(" Join A Group");
        button1.setOnAction(e -> primaryStage.setScene(scene6));
        GridPane.setConstraints(button1, 1, 2);
        button.setText(" Create A Group");// page 3 go here which contains how to create a group and start hosting.
        button.setOnAction(e -> primaryStage.setScene(scene3));
        grid2.getChildren().addAll(button, button1);
        scene2 = new Scene(grid2, 900, 800);
        scene2.getStylesheets().add(HomePage.class.getResource("style.css").toExternalForm());
        grid2.setId("pagetwo");
        */

// Next page after clicking on create a group
// Create Group
       /* System.out.println("");
        Label label5 = new Label("Create A Group");
        GridPane.setConstraints(label5, 0, 10);
        label5.setId("pagefour");
        back1 = new Button("Back");
        GridPane.setConstraints(back1, 0, 70);
        back1.setOnAction(e -> primaryStage.setScene(scene2));
        Label label3 = new Label(" Group Name: ");
        GridPane.setConstraints(label3, 0, 15);
        label3.setId("pagefour");
        //name
        TextField GName = new TextField();
        GridPane.setConstraints(GName, 1, 15);
        // pincode label
        Label label4 = new Label(" Pincode: ");
        GridPane.setConstraints(label4, 0, 19);
        label4.setId("pagefour");
        // text box
        TextField GName2 = new TextField();
        GName2.setPromptText("Optional");
        GridPane.setConstraints(GName2, 1, 19);
        CreateGroup = new Button(" Add Music ");
        GridPane.setConstraints(CreateGroup, 20, 20);
        CreateGroup.setOnAction(e -> primaryStage.setScene(scene4));
        //Layout3
        grid3.getChildren().addAll(back1, label3, label4, label5, CreateGroup, GName, GName2);
        scene3 = new Scene(grid3, 900, 800);
        scene3.getStylesheets().add(HomePage.class.getResource("style.css").toExternalForm());
        grid3.setId("pagethree");*/

//Start hosting page


// TESTING OVER HERE
        /*addmusic = new Button("Add Music");
        GridPane.setConstraints(addmusic, 0, 20);
        //addmusic.setOnAction(e -> System.out.println(" Greg this is where it should request your code to add music"));


        addmusic.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                //fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));   //Optional line of code to open file chooser at home directory
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("MP3 Files (.mp3)", "*.mp3"),
                        new FileChooser.ExtensionFilter("WAV Files (.wav)", "*.wav")
                );
                File file = fileChooser.showOpenDialog(primaryStage);
                String fileName = file.getName();
                System.out.println(fileName);
            }
        });





        label5 = new Label(" Songs List");
        label5.setId("Bigtext");
        GridPane.setConstraints(label5, 3, 1);
        back1 = new Button("Back");
        GridPane.setConstraints(back1, 0, 80);
        back1.setOnAction(e -> primaryStage.setScene(scene3));

        TableColumn<DisplaySongs4host, String> SongC = new TableColumn<>("Songs");
        SongC.setMinWidth(500);
        SongC.setCellValueFactory(new PropertyValueFactory<>("songName"));
        back1 = new Button("Back");
        GridPane.setConstraints(back1, 0, 80);
        back1.setOnAction(e -> primaryStage.setScene(scene3));
        Songtable = new TableView<>();
        Songtable.setItems(getSong());
        Songtable.getColumns().addAll(SongC);
        GridPane.setConstraints(Songtable, 1, 15);
        VBox vbox = new VBox();
        vbox.setSpacing(15);
        vbox.setPadding(new Insets(200, 200, 200, 200));
        vbox.getChildren().addAll(label5, addmusic, Songtable, back1);
        vbox.setId("pagesix");
        scene4 = new Scene(vbox);
        scene4.getStylesheets().add(HomePage.class.getResource("style.css").toExternalForm());*/


//bluetooth Page
        /*back1 = new Button("Tap to Cancel");
        GridPane.setConstraints(back1, 16, 43);
        back1.setOnAction(e -> primaryStage.setScene(scene2));
        grid6.getChildren().addAll(back1);
        scene6 = new Scene(grid6, 600, 500);
        scene6.getStylesheets().add(HomePage.class.getResource("style.css").toExternalForm());
        grid6.setId("Bluetooth");*/
// Show display
        primaryStage.setScene(new MainPage(primaryStage));
        primaryStage.show();

    }

    /*public ObservableList<DisplaySongs4host> getSong() {
        ObservableList<DisplaySongs4host> Songs = FXCollections.observableArrayList();
        Songs.add(new DisplaySongs4host("I hate Exams"));
        Songs.add(new DisplaySongs4host("I "));
        Songs.add(new DisplaySongs4host("Exams"));
        Songs.add(new DisplaySongs4host("hate "));
        return Songs;

    }*/

}

