package service;
import model.SalesRecord;
public class ValidationService {
    public static boolean isValid(SalesRecord s) {
        return s.orderId != null && s.quantity > 0 && s.price > 0;
    }
}