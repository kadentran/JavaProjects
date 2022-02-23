import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String _name;
    private final List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Customer name cannot be null");
        }
        
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Receipt receipt = new TextReceipt();
        printStatement(receipt);
        return receipt.toString();
    }

    public String statementXml() {
        Receipt receipt = new XmlReceipt();
        printStatement(receipt);
        return receipt.toString();
    }

    private void printStatement(Receipt receipt) {
        Double amountOwed = 0.0;
        Integer frequentRenterPoints = 0;

        receipt.makeReceiptHeader(getName());

        for (Rental rental : _rentals) {

            Double rentalAmount = rental.calculateAmount();
            amountOwed += rentalAmount;

            frequentRenterPoints += rental.calculateFrequentRenterPoints();

            receipt.makeReceiptLineItem(rental.getTitle(), rentalAmount);
        }

        receipt.makeReceiptFooter(amountOwed, frequentRenterPoints);
    }

}
