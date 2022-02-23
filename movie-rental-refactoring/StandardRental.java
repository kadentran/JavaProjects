public class StandardRental extends Rental {
    public static final Double  LATE_FEE = 1.5;
    public static final Integer FREQUENT_RENTER_POINTS_PER_MOVIE = 1;

    public StandardRental(Movie movie, Integer daysRented) {
        super(movie, daysRented);
    }

    @Override
    public Integer calculateFrequentRenterPoints() {
        return FREQUENT_RENTER_POINTS_PER_MOVIE;
    }

    @Override
    protected Double calculateCost() {
        return _movie.getRentalCost();
    }

    @Override
    protected Double calculateLateFees() {
        Double lateFees = 0.0;

        if (isLate()) {
            lateFees = (_daysRented - _movie.getRentalPeriod()) * LATE_FEE;
        }

        return lateFees;
    }

    private Boolean isLate() {
        return _daysRented > _movie.getRentalPeriod();
    }
}
