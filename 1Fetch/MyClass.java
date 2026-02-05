import java.sql.*;

public class MyClass {
    

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String pwd = "password";

        String sql = "SELECT * FROM students";

        try (
            Connection con = DriverManager.getConnection(url, username, pwd);
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
        ) {

            while (rs.next()) {
                System.out.println("id: "+rs.getInt("id"));
                System.out.println("name: "+rs.getString("name"));
                System.out.println("course: "+rs.getString("course"));
                System.out.println("age: "+rs.getString("age"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
