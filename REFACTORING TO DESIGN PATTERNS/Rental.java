public class Rental {
    private Movie _movie;
    private int _daysRented;
    private CostCalculator _costCalculator;
    private PointsCalculator _pointsCalculator;
    
    private Rental(Movie movie, int daysRented, CostCalculator costCalculator, PointsCalculator pointsCalculator) {
        _movie      = movie;
        _daysRented = daysRented;
        _costCalculator = costCalculator;
        _pointsCalculator = pointsCalculator;
    }
    
    public static Rental Create(Movie movie, Integer daysRented) {
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                return new Rental(movie, daysRented, new RegularRentalCostCalculator(), new StandardPointsCalculator());
            case Movie.NEW_RELEASE:
                return new Rental(movie, daysRented, new NewReleaseRentalCostCalculator(), new NewReleasePointsCalculator());
            case Movie.CHILDRENS:
                return new Rental(movie, daysRented, new ChildrensRentalCostCalculator(), new StandardPointsCalculator());
            default:
                throw new RuntimeException("Unknown price code");
        }
    }

    public int getDaysRented() {
        return _daysRented;
    }
    
    public Movie getMovie() {
        return _movie;
    }

    public Double calculateCost() {
        return _costCalculator.calculate(this);
    }

    public Integer calculateFrequentRentalPoints() {
        return _pointsCalculator.calculate(this);
    }
}