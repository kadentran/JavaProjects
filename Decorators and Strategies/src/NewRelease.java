public class NewRelease implements Rental {

    private static final Integer BONUS_POINTS_MINIMUM_RENTAL = 2;
    private static final Integer POINTS_PER_RELEASE = 1;
    private static final Double DAILY_RENTAL_COST = 3.0;

    private Rental _rental;

    public NewRelease(Rental rental) {
        _rental = rental;
    }

    @Override
    public Double calculateCost() {
        return _rental.getDaysRented() * DAILY_RENTAL_COST;
    }

    @Override
    public Integer calculatePoints() {
        Integer points = POINTS_PER_RELEASE;

        // add bonus for a multi-day new release rental
        if (_rental.getDaysRented() >= BONUS_POINTS_MINIMUM_RENTAL) {
            points++;
        }

        return points;
    }

    @Override
    public Integer getDaysRented() {
        return _rental.getDaysRented();
    }

    @Override
    public Movie getMovie() {
        return _rental.getMovie();
    }
}
