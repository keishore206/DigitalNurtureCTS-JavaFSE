import java.sql.*;
import java.util.*;

public class StudentDAO {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            PreparedStatement ps1 = con.prepareStatement(
                    "INSERT INTO college VALUES (?, ?, ?)");
            ps1.setString(1, name);
            ps1.setInt(2, id);
            ps1.setInt(3, age);
            ps1.executeUpdate();
            System.out.println("Record Inserted");
            System.out.print("Enter New Age: ");
            int newAge = sc.nextInt();
            PreparedStatement ps2 = con.prepareStatement(
                    "UPDATE college SET age=? WHERE id=?");

            ps2.setInt(1, newAge);
            ps2.setInt(2, id);
            ps2.executeUpdate();
            System.out.println("Record Updated");
            con.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}