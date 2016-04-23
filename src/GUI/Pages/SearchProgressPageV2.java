package GUI.Pages;

import GUI.Resources.Resources;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by davidsabzanov on 4/18/16.
 */
public class SearchProgressPageV2 extends Page {

    private int cycleCount = 2;

    public SearchProgressPageV2(){
        super();
        buildUI();
    }

    private void buildUI() {
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setId("Bluetooth");

        StackPane stackPane = new StackPane();


        //Set background
        ImageView background = Resources.getInstance().getImageView("searching1");
//        contentPane.getChildren().add(background);



        Rectangle circle1 = new Rectangle(0,0, 100,100);
        circle1.setArcHeight(100);
        circle1.setArcWidth(100);
        circle1.setFill(Color.WHITE);



        Rectangle circle2 = new Rectangle(0,0, 25,25);
        circle2.setArcHeight(25);
        circle2.setArcWidth(25);
        circle2.setFill(Color.WHITE);

        Rectangle circle3 = new Rectangle(0,0, 100,100);
        circle3.setArcHeight(100);
        circle3.setArcWidth(100);
        circle3.setFill(Color.web("#BDC3C7"));

        FadeTransition circle1fade =
                new FadeTransition(Duration.millis(3000), circle1);
        circle1fade.setFromValue(1.0f);
        circle1fade.setToValue(0.3f);
        circle1fade.setCycleCount(cycleCount);
        circle1fade.setAutoReverse(false);

        DropShadow circle3dropshadow = new DropShadow();
        circle3dropshadow.setOffsetX(0);
        circle3dropshadow.setOffsetY(0);
        circle3dropshadow.setColor(Color.WHITE);
        circle3dropshadow.setRadius(100.0);

        circle3.setEffect(circle3dropshadow);



        FadeTransition circle2fade =
                new FadeTransition(Duration.millis(3000), circle2);
        circle2fade.setFromValue(0.3f);
        circle2fade.setToValue(1.0f);
        circle2fade.setCycleCount(cycleCount);
        circle2fade.setAutoReverse(false);

        ScaleTransition circle2scale =
                new ScaleTransition(Duration.millis(3000), circle2);
        circle2scale.setToX(4f);
        circle2scale.setToY(4f);
        circle2scale.setCycleCount(cycleCount);
        circle2scale.setAutoReverse(false);



        Rectangle rectParallel = new Rectangle(0,0,100,100);
        rectParallel.setArcHeight(100);
        rectParallel.setArcWidth(100);
        rectParallel.setFill(null);
        rectParallel.setStroke(Color.WHITE);
        rectParallel.setStrokeWidth(3);



        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(1500), rectParallel);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.1f);
        fadeTransition.setCycleCount(cycleCount);
        fadeTransition.setAutoReverse(false);


        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.millis(3000), rectParallel);
        scaleTransition.setToX(10f);
        scaleTransition.setToY(10f);
        scaleTransition.setCycleCount(cycleCount);
        scaleTransition.setAutoReverse(false);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                scaleTransition,
                circle1fade,
                circle2fade,
                circle2scale
        );
        parallelTransition.setCycleCount(cycleCount);
        parallelTransition.play();


        //Pause and move to next page
        PauseTransition trans = new PauseTransition(Duration.seconds(6));
        //Duration must always be 3 x cycleCount to show a clean animation without interruption.
        trans.setOnFinished(e -> nextPage());
        trans.play();






        stackPane.getChildren().addAll(rectParallel, circle3, circle2, circle1, background);
        contentPane.getChildren().addAll(stackPane);
    }

    @Override
    public void nextPage() {
        Window.setScene(Window.PAGE.HOSTLIST);
    }

    @Override
    public void prevPage() {
        Window.setScene(Window.PAGE.OPTIONS);
    }
}
