// Angela Vargas - CSD420 Module 7 Assignment
// Displays 4 styled circles using external CSS

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FourCirclesCSS extends Application {

    @Override
    public void start(Stage primaryStage) {

        double r = 40;           // circle radius
        double frameWidth = 95;  // width of the rectangle around first circle

        // Root pane (we will bind rectangle height to this)
        StackPane root = new StackPane();
        root.setStyle("-fx-padding: 10;"); // small padding so rectangle doesn't stick to window edge

        // First circle (styled by CSS)
        Circle c1 = new Circle(r);
        c1.getStyleClass().add("plaincircle");

        // Rectangle that goes behind only the first circle and will stretch full scene height
        Rectangle rect1 = new Rectangle(frameWidth, 100); // initial height (will be overwritten by binding)
        rect1.setFill(Color.TRANSPARENT);
        rect1.setStroke(Color.BLACK);
        rect1.setStrokeWidth(8); // thick border

        // Bind rectangle height to root height so it fills the window vertically
        rect1.heightProperty().bind(root.heightProperty().subtract(20)); // subtract padding for nicer fit

        // StackPane that holds rectangle + circle for the first position
        StackPane box1 = new StackPane(rect1, c1);
        box1.setAlignment(Pos.CENTER);

        // Other circles (use invisible frames if you want exact alignment; here we rely on same circle size)
        Circle c2 = new Circle(r);
        c2.getStyleClass().add("plaincircle");

        Circle c3 = new Circle(r);
        c3.setId("redcircle");

        Circle c4 = new Circle(r);
        c4.setId("greencircle");

        // Put all items in an HBox so they are horizontally aligned
        HBox hbox = new HBox(30, box1, c2, c3, c4);
        hbox.setAlignment(Pos.CENTER);

        // Add HBox into root
        root.getChildren().add(hbox);

        Scene scene = new Scene(root, 650, 300);

        // Attach external CSS (must be in same folder or on classpath)
        // If this doesn't load for you, try the getResource() alternative below (commented).
        scene.getStylesheets().add("mystyle.css");
        // scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setTitle("Four Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
