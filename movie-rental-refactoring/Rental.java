public abstract class Rental {
    protected final Movie     _movie;
    protected final Integer   _daysRented;

    public Rental(Movie movie, Integer daysRented) {

        if (movie == null) {
            throw new IllegalArgumentException("movie parameter cannot be null");
        }

        if (daysRented < 1) {
            throw new IllegalArgumentException("daysRented must be 1 or more");
        }
        
        _movie      = movie;
        _daysRented = daysRented;
    }

    public Integer getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public String getTitle() {
        return _movie.getTitle();
    }

    public Double calculateAmount() {
         return calculateCost() + calculateLateFees();
    }

    public abstract Integer calculateFrequentRenterPoints();

    protected abstract Double calculateCost();
    
    protected abstract Double calculateLateFees();
}
