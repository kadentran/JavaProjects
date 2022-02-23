
// A frequent rental point computation that gives double regular points to any
// customer who is renting both regular and children movies
public class DoublePointsRegularChildren implements FrequentRenterPoints {

    @Override
    public Integer getPoints(ShoppingCart cart) {
        Boolean hasChildrensMovie = false;
        Boolean hasRegularMovie = false;
        Integer totalPoints = 0;

        for (Rental rental : cart.getRentals()) {
            totalPoints += rental.calculatePoints();

            MovieTypes movieType = rental.getMovie().getMovieType();

            if (movieType == MovieTypes.REGULAR) {
                hasRegularMovie = true;
            }

            if (movieType == MovieTypes.CHILDRENS) {
                hasChildrensMovie = true;
            }
        }

        if (hasRegularMovie && hasChildrensMovie) {
            return totalPoints * 2;
        }

        return totalPoints;
    }
}
