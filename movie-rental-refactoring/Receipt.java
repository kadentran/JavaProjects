public interface Receipt {
    void makeReceiptHeader(String name);

    void makeReceiptLineItem(String movieTitle, Double amount);

    void makeReceiptFooter(Double amountOwed, Integer frequentRenterPoints);

    String toString();
}
