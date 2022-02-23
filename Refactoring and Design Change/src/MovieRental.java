public class MovieRental extends Rental {
    private final Movie _movie;
    private final int _daysRented;
    private final RentalCostCalculator _costCalculator;
    private final PointsCalculator _pointsCalculator;
    
    private MovieRental(Movie movie, int daysRented, RentalCostCalculator costCalculator, PointsCalculator pointsCalculator) {
        _movie      = movie;
        _daysRented = daysRented;
        _costCalculator = costCalculator;
        _pointsCalculator = pointsCalculator;
    }
    
    public static MovieRental Create(Movie movie, Integer daysRented) {
        switch (movie.getMovieType()) {
            case REGULAR:
                return new MovieRental(movie, daysRented, new RegularRentalCostCalculator(), new StandardPointsCalculator());
            case CHILDRENS:
                return new MovieRental(movie, daysRented, new ChildrensRentalCostCalculator(), new StandardPointsCalculator());
            default:
                throw new RuntimeException("Unknown price code");
        }
    }

    @Override
    public Integer getDaysRented() {
        return _daysRented;
    }
    
    public Movie getMovie() {
        return _movie;
    }

    public Double getPrice() {
        return _costCalculator.calculate(this);
    }

    public Integer calculateFrequentRentalPoints() {
        return _pointsCalculator.calculate(this);
    }

    @Override
    public Integer getPoints() {
        return this.calculateFrequentRentalPoints();
    }

    @Override
    public ItemType getItemType() {
        return ItemType.MOVIE;
    }

    @Override
    public String getName() {
        return _movie.getName();
    }

}