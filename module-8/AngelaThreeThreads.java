// Angela Vargas CSD420 8.2 Programming Assignment
// This program demonstrates multithreading in Java by creating
// three active threads that generate random characters:
// - Thread A: Random letters (a–z)
// - Thread B: Random digits (0–9)
// - Thread C: Random symbols (! @ # $ % & *)
// A JavaFX TextArea displays the generated results as the threads run.
// Each thread produces at least 10,000 characters.
// Test code validates all threads complete successfully.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AngelaThreeThreads extends Application {

    // Text display area
    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {

        textArea.setEditable(false);
        textArea.setWrapText(true);

        BorderPane pane = new BorderPane(textArea);
        Scene scene = new Scene(pane, 650, 500);

        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Thread for random letters
        Thread lettersThread = new Thread(() -> produceRandomCharacters("abcdefghijklmnopqrstuvwxyz"));

        // Thread for random digits
        Thread numberThread = new Thread(() -> produceRandomCharacters("0123456789"));

        // Thread for random symbols
        Thread symbolThread = new Thread(() -> produceRandomCharacters("!@#$%&*"));

        // Start the threads
        lettersThread.start();
        numberThread.start();
        symbolThread.start();
    }

    /**
     * Generates at least 10,000 random characters from a given set and appends them
     * to the TextArea on the JavaFX thread.
     */
    private void produceRandomCharacters(String set) {
        for (int i = 0; i < 10000; i++) {
            char ch = set.charAt((int)(Math.random() * set.length()));
            javafx.application.Platform.runLater(() -> textArea.appendText(String.valueOf(ch)));
        }
        // Basic confirmation message for test validation
        System.out.println("Thread finished: " + set);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
