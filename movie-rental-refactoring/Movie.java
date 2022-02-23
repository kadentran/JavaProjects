public abstract class Movie {
    private final String _title;

    public Movie(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Movie title cannot be null");
        }
        
        _title = title;
    }

    public String getTitle() {
        return _title;
    }

    public abstract Integer getRentalPeriod();

    public abstract Double getRentalCost();

}