// 1.1 programming assignment Angela Vargas CSD420
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.Collections;
import java.util.ArrayList;

public class Vargas_CardDisplay extends Application {

    private static final int CARD_COUNT = 4; // number of cards to display
    private static final int TOTAL_CARDS = 52; // total cards in the deck
    private static final String CARD_PATH = "cards/"; // directory for images

    private HBox cardBox; // layout to hold card images

    @Override
    public void start(Stage primaryStage) {
        // Create layout
        cardBox = new HBox(10);
        cardBox.setStyle("-fx-alignment: center;");

        // Create button to refresh cards
        Button refreshButton = new Button("Refresh Cards");

        // Use lambda expression for button action
        refreshButton.setOnAction(e -> showRandomCards());

        // Initial card display
        showRandomCards();

        // Layout arrangement
        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 15; -fx-alignment: center;");
        root.getChildren().addAll(cardBox, refreshButton);

        // Set up scene
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showRandomCards() {
        // Clear existing cards
        cardBox.getChildren().clear();

        // Create a list of card numbers 1–52
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            cards.add(i);
        }

        // Shuffle to randomize card order
        Collections.shuffle(cards);

        // Display first 4 cards
        for (int i = 0; i < CARD_COUNT; i++) {
            String filePath = CARD_PATH + cards.get(i) + ".png";
            Image cardImage = new Image(filePath);
            ImageView imageView = new ImageView(cardImage);
            imageView.setFitHeight(150);
            imageView.setPreserveRatio(true);
            cardBox.getChildren().add(imageView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}