import java.util.ArrayList;
import java.util.List;

public class Order {

    int orderId;
    String customerName;
    String vendorName;
    String vendorAddress;
    int billNo;
    String modeOfPayment;
    List<Item> items;

    public Order(int orderId, String customerName, String vendorName, String vendorAddress,
                 int billNo, String modeOfPayment, List<Item> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.billNo = billNo;
        this.modeOfPayment = modeOfPayment;
        this.items = items;
    }
}
