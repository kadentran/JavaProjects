import java.util.ArrayList;
import java.util.List;

public class ConcreteShoppingCart implements ShoppingCart {

    private List<Rental> _rentals = new ArrayList<Rental>();
    private final FrequentRenterPoints _frequentPoints;

    public ConcreteShoppingCart(FrequentRenterPoints frequentPoints) {
        _frequentPoints = frequentPoints;
    }

    @Override
    public Double calculateCost() {
        Double totalCost = 0.0;

        for (Rental rental : _rentals) {
            Double rentalCost = rental.calculateCost();
            totalCost += rentalCost;
        }

        return totalCost;
    }

    @Override
    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    @Override
    public Integer calculatePoints() {
        return _frequentPoints.getPoints(this);
    }

    @Override
    public List<Rental> getRentals() {
        return _rentals;
    }
}

