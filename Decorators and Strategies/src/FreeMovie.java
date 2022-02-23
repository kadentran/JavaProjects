
// Give the customer the highest priced movie for free if they
// have accrued at least 10 frequent renter points in the past.
public class FreeMovie extends PointsDiscount {

    public FreeMovie(ShoppingCart cart, Customer cust) {
        super(cart, cust);
    }

    @Override
    public Double getDiscount(Double balance) {
        if (_cust.getPoints() < 10.0) {
            return 0.0;
        }

        return highestPricedMovie();
    }

    private Double highestPricedMovie() {
        Double maxMovieCost = 0.0;

        for (Rental rental : _cart.getRentals()) {
            maxMovieCost = Math.max(maxMovieCost, rental.calculateCost());
        }

        return maxMovieCost;
    }

    @Override
    public String description() {
        return "Free movie for 10 points";
    }
}
