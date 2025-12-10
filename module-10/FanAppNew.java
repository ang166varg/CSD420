/*
 * Angela Vargas
 * CSD-420
 * Assignment: Fan Database Viewer and Updater
 */
package fanappnew;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class FanAppNew extends Application {

    // Database connection info
    private static final String URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASS = "pass";

    // GUI fields
    TextField txtID = new TextField();
    TextField txtFirst = new TextField();
    TextField txtLast = new TextField();
    TextField txtTeam = new TextField();

    // Buttons
    Button btnDisplay = new Button("Display");
    Button btnUpdate = new Button("Update");

    @Override
    public void start(Stage stage) {

        // Labels
        Label lblID = new Label("ID:");
        Label lblFirst = new Label("First Name:");
        Label lblLast = new Label("Last Name:");
        Label lblTeam = new Label("Favorite Team:");

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(lblID, 0, 0);     grid.add(txtID, 1, 0);
        grid.add(lblFirst, 0, 1);  grid.add(txtFirst, 1, 1);
        grid.add(lblLast, 0, 2);   grid.add(txtLast, 1, 2);
        grid.add(lblTeam, 0, 3);   grid.add(txtTeam, 1, 3);

        HBox buttonBox = new HBox(10, btnDisplay, btnUpdate);
        grid.add(buttonBox, 1, 4);

        btnDisplay.setOnAction(e -> displayFan());
        btnUpdate.setOnAction(e -> updateFan());

        Scene scene = new Scene(grid, 350, 250);
        stage.setTitle("Fan Database Viewer");
        stage.setScene(scene);
        stage.show();
    }

    // --------------------------------------------------
    // DISPLAY FAN BY ID
    // --------------------------------------------------
    private void displayFan() {
        String sql = "SELECT firstname, lastname, favoriteteam FROM fans WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(txtID.getText()));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                txtFirst.setText(rs.getString("firstname"));
                txtLast.setText(rs.getString("lastname"));
                txtTeam.setText(rs.getString("favoriteteam"));
            } else {
                showAlert("Record not found.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert("Error displaying record: " + ex.getMessage());
        }
    }

    // --------------------------------------------------
    // UPDATE FAN RECORD
    // --------------------------------------------------
    private void updateFan() {
        String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, txtFirst.getText());
            stmt.setString(2, txtLast.getText());
            stmt.setString(3, txtTeam.getText());
            stmt.setInt(4, Integer.parseInt(txtID.getText()));

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                showAlert("Record updated successfully!");
            } else {
                showAlert("Update failed. ID not found.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert("Error updating record: " + ex.getMessage());
        }
    }

    // --------------------------------------------------
    // SHOW ALERT POPUP
    // --------------------------------------------------
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
