import java.sql.*;
public class JDBCConnectivity {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    url, username, password);
            System.out.println("Connected to database successfully!");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM college";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\nStudent Records:");
            System.out.println("ID\tName\tAge");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + "\t" + name + "\t" + age);
            }
            rs.close();
            stmt.close();
            con.close();

            System.out.println("\nConnection Closed.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}