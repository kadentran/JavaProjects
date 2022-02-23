public class XmlReceipt implements Receipt {
    private String _receipt = "";

    @Override
    public void makeReceiptHeader(String name) {
        _receipt += "  <name>" + name + "</name>\n";

    }

    @Override
    public void makeReceiptLineItem(String movieTitle, Double amount) {
        _receipt += "  <movie>\n" + "    <title>" + movieTitle + "</title>\n" + "    <amount>" + amount + "</amount>"
                + "\n  </movie>" + "\n";

    }

    @Override
    public void makeReceiptFooter(Double amountOwed, Integer frequentRenterPoints) {
        _receipt += "  <total>" + amountOwed + "</total>" + "\n";
        _receipt += "  <points>" + frequentRenterPoints + "</points>";
    }

    @Override
    public String toString() {
        return "<receipt>\n" + _receipt + "\n</receipt>";
    }
}
