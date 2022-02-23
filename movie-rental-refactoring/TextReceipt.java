public class TextReceipt implements Receipt {
    private String _receipt = "";

    @Override
    public void makeReceiptHeader(String name) {
        _receipt += "Rental Record for " + name + "\n";

    }

    @Override
    public void makeReceiptLineItem(String movieTitle, Double amount) {
        _receipt += "\t" + movieTitle + "\t" + amount + "\n";

    }

    @Override
    public void makeReceiptFooter(Double amountOwed, Integer frequentRenterPoints) {
        _receipt += "Amount owed is " + amountOwed + "\n";
        _receipt += "You earned " + frequentRenterPoints + " frequent renter points\n";
    }

    @Override
    public String toString() {
        return _receipt;
    }
}
