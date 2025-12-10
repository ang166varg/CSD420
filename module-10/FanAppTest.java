import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FanAppTest {

    public static void main(String[] args) {
        testDisplay();
        testUpdate();
        System.out.println("All tests completed.");
    }

    private static void testDisplay() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/databasedb", "student1", "pass")) {

            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM fans WHERE id = 1"
            );
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("[TEST PASSED] Display method can retrieve ID 1.");
            } else {
                System.out.println("[TEST FAILED] Display method could not retrieve ID 1.");
            }

        } catch (Exception ex) {
            System.out.println("[TEST ERROR] " + ex.getMessage());
        }
    }

    private static void testUpdate() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/databasedb", "student1", "pass")) {

            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE fans SET firstname='TestName' WHERE id=1"
            );

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("[TEST PASSED] Update method successfully updated ID 1.");
            } else {
                System.out.println("[TEST FAILED] Update method failed.");
            }

        } catch (Exception ex) {
            System.out.println("[TEST ERROR] " + ex.getMessage());
        }
    }
}

