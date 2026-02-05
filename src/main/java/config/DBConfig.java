package config;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConfig {
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/retail_db",
            "root",
            "password"
        );
    }
}