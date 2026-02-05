package service;
import dao.SalesDAO;
import model.SalesRecord;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
public class APIIngestionService {
    public void ingestFromAPI(String apiUrl) throws Exception {
        String json = new String(new URL(apiUrl).openStream().readAllBytes(), StandardCharsets.UTF_8);
        JSONArray arr = new JSONArray(json);
        SalesDAO dao = new SalesDAO();
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            SalesRecord s = new SalesRecord();
            s.orderId = o.getString("order_id");
            s.productName = o.getString("product");
            s.quantity = o.getInt("qty");
            s.price = o.getDouble("price");
            s.saleDate = Date.valueOf(o.getString("date"));
            if (ValidationService.isValid(s)) {
                dao.insertSale(s);
            }
        }
    }
}