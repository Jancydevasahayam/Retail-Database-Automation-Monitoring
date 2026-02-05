package dao;
import config.DBConfig;
import model.SalesRecord;
import java.sql.*;
public class SalesDAO {
    public void insertSale(SalesRecord s) throws Exception {
        long start = System.currentTimeMillis();
        Connection con = DBConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO sales(order_id, product_name, quantity, price, sale_date) VALUES(?,?,?,?,?)"
        );
        ps.setString(1, s.orderId);
        ps.setString(2, s.productName);
        ps.setInt(3, s.quantity);
        ps.setDouble(4, s.price);
        ps.setDate(5, s.saleDate);
        ps.executeUpdate();
        long end = System.currentTimeMillis();
        logQuery("INSERT sales", end - start);
    }
    private void logQuery(String q, long t) throws Exception {
        Connection con = DBConfig.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO query_monitor(query_text, execution_time_ms) VALUES (?,?)"
        );
        ps.setString(1, q);
        ps.setLong(2, t);
        ps.executeUpdate();
    }
}