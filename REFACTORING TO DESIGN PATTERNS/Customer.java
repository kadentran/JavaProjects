import java.util.List;
import java.util.ArrayList;

public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();
    
    public Customer (String name) {
        _name = name;
    }
    
    public void addRental(Rental arg) {
        _rentals.add(arg);
    }
    
    public String getName() {
        return _name;
    }
    
    public String statement() {
        Double      totalCost            = 0.0;
        Integer     frequentRenterPoints = 0;
        String      result               = "Rental Record for " + getName() + "\n";
        
        for (Rental rental : _rentals) {
            Double rentalCost = rental.calculateCost();
            
            frequentRenterPoints += rental.calculateFrequentRentalPoints();
            
            result += "\t" + rental.getMovie().getTitle() +
                    "\t" + String.valueOf(rentalCost) + "\n";
                      
            totalCost += rentalCost;
        }
        
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalCost) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                  " frequent renter points";
        return result;
    }
}