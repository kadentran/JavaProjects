public class NewReleaseRentalCostCalculator extends CostCalculator {

    private static final Double DAILY_RENTAL_COST = 3.0;

    @Override
    public Double calculate(Rental rental) {
        return rental.getDaysRented() * DAILY_RENTAL_COST;
    }
}