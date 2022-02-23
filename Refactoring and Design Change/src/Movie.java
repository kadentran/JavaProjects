public class Movie {
    
    private final String _title;
    private final MovieTypes _movieType;
    
    public Movie(String title, MovieTypes movieType) {
        _title = title;
        _movieType = movieType;
    }
    
    public MovieTypes getMovieType() {
        return _movieType;
    }
    
    public String getName() {
        return _title;
    }
}