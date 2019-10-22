/**
 * Class that encapsulates a loan.
 */
public class Loan {
    private String loanID;
    private String customerID;
    private double interest;
    private double amount;
    private String selectedCurrency;
    private boolean isPaidOff;

    Loan(String customerID, double amount, double interest, String selectedCurrency, int postfix) {
        this.customerID = customerID;
        this.amount = amount;
        this.interest = interest;
        this.isPaidOff = false;
        this.selectedCurrency = selectedCurrency;
        this.loanID = customerID + "_" + amount + "_" + postfix;
    }

    private void setPaid() {
        this.isPaidOff = true;
    }

    public double getInterest() {
        return this.interest;
    }

    public String getLoanID() {
        return this.loanID;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public String getSelectedCurrency() {
        return this.selectedCurrency;
    }
    public double getAmount() {
        return this.amount;
    }

    public boolean isPaidOff() {
        return this.isPaidOff;
    }

    public double payByAmount(double paid_amount) {
        if (paid_amount < this.amount) {
            double diff_amount = this.amount - paid_amount;
            this.amount -= diff_amount;
            return diff_amount;
        } else {
            this.setPaid();
            return paid_amount - this.amount;
        }
    }

    public double computeInterest() {
        return getAmount() * getInterest();
    }

}
