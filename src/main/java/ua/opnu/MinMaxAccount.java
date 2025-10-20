import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        int bal = getBalance();
        this.min = bal;
        this.max = bal;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateBounds();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateBounds();
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    private void updateBounds() {
        int b = getBalance();
        if (b < min) min = b;
        if (b > max) max = b;
    }
}
