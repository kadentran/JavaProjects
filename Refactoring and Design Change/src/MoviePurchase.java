public class MoviePurchase extends Purchase {

    private final Movie _movie;
    private final PurchaseCostCalculator _costCalculator;

    private MoviePurchase(Movie movie, PurchaseCostCalculator costCalculator) {
        _movie = movie;
        _costCalculator = costCalculator;
    }

    public static MoviePurchase Create(Movie movie) {
        switch (movie.getMovieType()) {
            case REGULAR:
                return new MoviePurchase(movie, new RegularMoviePurchaseCostCalculator());
            case CHILDRENS:
                return new MoviePurchase(movie, new ChildrensMoviePurchaseCostCalculator());
            default:
                throw new RuntimeException("Unable to calculate cost of unknown movie type");
        }
    }

    public Movie getMovie() {
        return _movie;
    }
    
    @Override
    public Double getPrice() {
        return _costCalculator.calculate(this);
    }

    @Override
    public Integer getPoints() {
        return 0;
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
