public class NewReleaseRental extends Rental {
    public static final Double NEW_RELEASE_RENTAL_COST = 3.0;
    public static final Integer FREQUENT_RENTER_POINTS_PER_NEW_RELEASE = 1;
    public static final Integer BONUS_POINTS_MINIMUM_RENTAL = 2;

    public NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public Integer calculateFrequentRenterPoints() {
        Integer frequentRenterPoints = FREQUENT_RENTER_POINTS_PER_NEW_RELEASE;

        if (this.getDaysRented() >= BONUS_POINTS_MINIMUM_RENTAL) {
            frequentRenterPoints++;
        }

        return frequentRenterPoints;
    }

    @Override
    protected Double calculateCost() {
        return _daysRented * NEW_RELEASE_RENTAL_COST;
    }

    @Override
    protected Double calculateLateFees() {
        return 0.0;
    }
}
