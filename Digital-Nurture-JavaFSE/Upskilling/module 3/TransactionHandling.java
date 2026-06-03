import java.sql.*;
public class TransactionHandling {
    static final String URL = "jdbc:mysql://localhost:3306/test";
    static final String USER = "root";
    static final String PASSWORD = "";
    public static void transferMoney(int fromAcc, int toAcc, double amount) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            con.setAutoCommit(false);
            String debitQuery ="UPDATE accounts SET Amount = Amount - ? WHERE Id = ?";
            PreparedStatement debitStmt =con.prepareStatement(debitQuery);
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAcc);
            int debitRows = debitStmt.executeUpdate();
            String creditQuery = "UPDATE accounts SET Amount = Amount + ? WHERE Id = ?";
            PreparedStatement creditStmt = con.prepareStatement(creditQuery);
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAcc);
            int creditRows = creditStmt.executeUpdate();
            if (debitRows > 0 && creditRows > 0) {
                con.commit();
                System.out.println("\nTransaction Successful!");
            } else {
                con.rollback();
                System.out.println("\nTransaction Failed! Rolled Back.");
            }
        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("\nError Occurred! Transaction Rolled Back.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void displayAccounts() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM accounts");
            System.out.println("\nAccount Details");
            System.out.println("---------------------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + " | " +
                        rs.getString("Name") + " | " +
                        rs.getDouble("Amount"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Before Transfer:");
        displayAccounts();
        transferMoney(101, 102, 2000);
        System.out.println("\nAfter Transfer:");
        displayAccounts();
    }
}