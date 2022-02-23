public class ChildrensRentalCostCalculator extends CostCalculator {

    private static final Double RENTAL_COST = 1.5;
    public static final Double DAILY_LATE_FEE = 1.5;
    private static final Integer RENTAL_PERIOD = 3;

    @Override
    public Double calculate(MovieRental rental) {
        Double rentalAmount = RENTAL_COST;

        if (rental.getDaysRented() > RENTAL_PERIOD) {
            rentalAmount += (rental.getDaysRented() - RENTAL_PERIOD) * DAILY_LATE_FEE;
        }

        return rentalAmount;
    }
}