package ua.opnu.java.inheritance.bill;

public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();
        return regularCustomer ? total - discountAmount : total;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || super.getTotal() == 0) return 0.0;
        return Math.round((100 - ((getTotal() * 100) / super.getTotal())) * 1e13) / 1e13;
    }
}
