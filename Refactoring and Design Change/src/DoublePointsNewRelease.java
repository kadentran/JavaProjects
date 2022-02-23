// This rental point computation gives double regular 
// points to any customer who is 18-22 and renting one or multiple 
// new release movies.
public class DoublePointsNewRelease implements FrequentPoints {

    private final Customer _cust;

    public DoublePointsNewRelease(Customer cust) {
        _cust = cust;
    }

    @Override
    public Integer getPoints(ShoppingCart cart) {
        Integer totalPoints = 0;
        Boolean getsDoublePoints = false;

        for (ShoppingCartItem rental : cart.getItems()) {
            totalPoints += rental.getPoints();

            if (meetsCriteria(rental)) {
                getsDoublePoints = true;
            }
        }

        if (getsDoublePoints) {
            return totalPoints * 2;
        }

        return totalPoints;
    }
    
    private boolean meetsCriteria(ShoppingCartItem rental) {
        return _cust.getAge() >= 18 && _cust.getAge() <= 22 && rental instanceof NewRelease;
    }
}
