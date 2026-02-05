import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteStudent {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "password";
        String sql = "DELETE FROM students WHERE id = ?";
        try(
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setInt(1,1);
            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted > 0){
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with ID 1");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
