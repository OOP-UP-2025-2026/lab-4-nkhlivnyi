import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private final GroceryBill base;
    private final boolean regularCustomer;
    private int discountCount = 0;
    private double discountAmount = 0.0;
    private double fullTotal = 0.0;
    private double discountedTotal = 0.0;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.base = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(Item i) {
        base.add(i);
        fullTotal += i.getPrice();
        if (regularCustomer) {
            double d = i.getDiscount();
            if (d > 0.0) {
                discountCount++;
                discountAmount += d;
            }
            discountedTotal += i.getPrice() - d;
        }
    }

    public double getTotal() {
        return round2(regularCustomer ? discountedTotal : fullTotal);
    }

    public Employee getClerk() {
        return base.getClerk();
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? round2(discountAmount) : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || fullTotal == 0.0) return 0.0;
        double paid = discountedTotal;
        return 100.0 - (paid * 100.0) / fullTotal;
    }

    private double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
