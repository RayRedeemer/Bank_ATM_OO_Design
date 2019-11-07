package backend;
/**
 * Transaction: request loan
 */
public class LoanCreate extends Transaction {
    private double loanAmount;

    LoanCreate(String userID, int creationDay, String selectedCurrency, double loanAmount) {
        super(userID, creationDay, selectedCurrency, "LoanCreate");
        this.loanAmount = loanAmount;
    }

    /**
     * execute transaction: request loan
     */
    public String startTransaction() {
        return BankPortal.getInstance().getBank().takeLoan(getUserID(), getLoanAmount(), getSelectedCurrency());
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }
}

