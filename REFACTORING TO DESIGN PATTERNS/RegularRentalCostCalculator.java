public class RegularRentalCostCalculator extends CostCalculator {

    private static final Double RENTAL_COST = 2.0;
    public static final Double DAILY_LATE_FEE = 1.5;
    private static final Integer RENTAL_PERIOD = 2;

    @Override
    public Double calculate(Rental rental) {
        Double rentalAmount = RENTAL_COST;

        if (rental.getDaysRented() > RENTAL_PERIOD) {
            rentalAmount += (rental.getDaysRented() - RENTAL_PERIOD) * DAILY_LATE_FEE;
        }

        return rentalAmount;
    }
}