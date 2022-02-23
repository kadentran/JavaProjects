public class RegularMovie extends Movie {
    private static final Double  RENTAL_COST   = 2.0;
    private static final Integer RENTAL_PERIOD = 2;

    public RegularMovie(String title) {
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
