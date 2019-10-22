/**
 * Class that represents USD, one of the currencies our system needs.
 */
public class YEN extends Currency {
    private double exchangeRate;

    YEN() {
        super("YEN", 10, 0);
        this.exchangeRate = 10;
    }

    YEN(double balance) {
        super("YEN", 10, balance);
        this.exchangeRate = 10;
    }
}
