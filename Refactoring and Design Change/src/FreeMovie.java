
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

        for (ShoppingCartItem rental : _cart.getItems()) {
            maxMovieCost = Math.max(maxMovieCost, rental.getPrice());
        }

        return maxMovieCost;
    }

    @Override
    public String description() {
        return "Free movie for 10 points";
    }
}
