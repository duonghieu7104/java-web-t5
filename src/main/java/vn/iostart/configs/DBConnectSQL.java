package vn.iostart.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {
    private final String serverName = "localhost";
    private final String dbName = "users";
    private final String portNumber = "1433";
    private final String instance = ""; // Instance name if any, otherwise leave empty
    private final String userID = "sa";  // Ensure this is correct
    private final String password = "minhhieu";  // Ensure this is correct

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber +
                (instance != null && !instance.trim().isEmpty() ? "\\" + instance : "") +
                ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";

        // Make sure to pass userID and password
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try (Connection conn = new DBConnectSQL().getConnection()) {
            if (conn != null) {
                System.out.println("Kết nối thành công: " + conn);
            }
        } catch (SQLException e) {
            System.err.println("Không thể kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}