import java.sql.*;
import java.util.Scanner;

public class InsertStudent {
    

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String pwd = "password";

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        String sql = "INSERT INTO students (id, name, course, age) VALUES (?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(url, username, pwd);
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, course);
            pstmt.setInt(4, age);
            
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("Student record inserted successfully!");
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            sc.close();
        }
    }
}
