import java.util.List;
import java.util.ArrayList;

public class Customer {
    private final String _name;
    private final Integer _age;
    private final Integer _points;

    private List<ShoppingCartItem> _rentals = new ArrayList<ShoppingCartItem>();

    public Customer(String name, Integer age, Integer points) {
        _name = name;
        _age = age;
        _points = points;
    }

    public Integer getPoints() {
        return _points;
    }

    public Integer getAge() {
        return _age;
    }

    public void addRental(ShoppingCartItem arg) {
        _rentals.add(arg);
    }
    
    public String getName() {
        return _name;
    }
    
    // public String statement() {
    //     Double      totalCost            = 0.0;
    //     Integer     frequentRenterPoints = 0;
    //     String      result               = "Rental Record for " + getName() + "\n";
        
    //     for (var rental : _rentals) {
    //         Double rentalCost = rental.calculateCost();
            
    //         frequentRenterPoints += rental.calculatePoints();
            
    //         result += "\t" + rental.getMovie().getTitle() +
    //                 "\t" + String.valueOf(rentalCost) + "\n";
                      
    //         totalCost += rentalCost;
    //     }
        
    //     // add footer lines
    //     result += "Amount owed is " + String.valueOf(totalCost) + "\n";
    //     result += "You earned " + String.valueOf(frequentRenterPoints) +
    //               " frequent renter points";
    //     return result;
    // }
}