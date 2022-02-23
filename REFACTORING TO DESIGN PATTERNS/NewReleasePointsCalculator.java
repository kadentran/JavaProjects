public class NewReleasePointsCalculator extends PointsCalculator {

    private static final Integer BONUS_POINTS_MINIMUM_RENTAL = 2;
    private static final Integer POINTS_PER_RELEASE = 1;

    @Override
    public Integer calculate(Rental rental) {
        Integer points = POINTS_PER_RELEASE;

        // add bonus for a multi-day new release rental
        if (rental.getDaysRented() >= BONUS_POINTS_MINIMUM_RENTAL) {
            points++;
        }

        return points;
    }
}
