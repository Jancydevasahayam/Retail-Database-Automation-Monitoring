package service;
import config.DBConfig;
import java.sql.*;
public class MonitoringService {
    public void detectSlowQueries() throws Exception {
        Connection con = DBConfig.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT * FROM query_monitor WHERE execution_time_ms > 200"
        );
        while (rs.next()) {
            System.out.println("Slow Query: " +
                rs.getString("query_text") +
                " Time: " + rs.getInt("execution_time_ms"));
        }
    }
}