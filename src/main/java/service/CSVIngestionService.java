package service;
import com.opencsv.CSVReader;
import dao.SalesDAO;
import model.SalesRecord;
import java.io.FileReader;
import java.sql.Date;
public class CSVIngestionService {
    public void ingest(String filePath) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        SalesDAO dao = new SalesDAO();
        String[] line;
        reader.readNext();
        while ((line = reader.readNext()) != null) {
            SalesRecord s = new SalesRecord();
            s.orderId = line[0];
            s.productName = line[1];
            s.quantity = Integer.parseInt(line[2]);
            s.price = Double.parseDouble(line[3]);
            s.saleDate = Date.valueOf(line[4]);
            if (ValidationService.isValid(s)) {
                dao.insertSale(s);
            }
        }
    }
}