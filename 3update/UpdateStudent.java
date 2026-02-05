import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateStudent {

    public static void main(String[] args) {

        // Database details
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "password";

        // SQL with 4 parameters (VERY IMPORTANT)
        String sql = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";

        try (
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            // Set values (order must match ? in SQL)
            ps.setString(1, "pratik patil");
            ps.setInt(2, 21);
            ps.setString(3, "Computer Science");
            ps.setInt(4, 12); // student id

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No student found with ID 101");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
