public class ChildrensMovie extends Movie {
    private static final Double RENTAL_COST = 1.5;
    private static final Integer RENTAL_PERIOD = 3;

    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public Integer getRentalPeriod()
    {
        return RENTAL_PERIOD;
    }

    @Override
    public Double getRentalCost()
    {
        return RENTAL_COST;
    }
}
