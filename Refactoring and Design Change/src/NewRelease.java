public class NewRelease extends Rental {

    private static final Integer BONUS_POINTS_MINIMUM_RENTAL = 2;
    private static final Integer POINTS_PER_RELEASE = 1;
    private static final Double DAILY_RENTAL_COST = 3.0;

    private MovieRental _rental;

    public NewRelease(MovieRental rental) {
        _rental = rental;
    }

    @Override
    public Double getPrice() {
        return _rental.getDaysRented() * DAILY_RENTAL_COST;
    }

    @Override
    public Integer getPoints() {
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

    public Movie getMovie() {
        return _rental.getMovie();
    }

    @Override
    public ItemType getItemType() {
        return _rental.getItemType();
    }

    @Override
    public String getName() {
        return _rental.getName();
    }
}
