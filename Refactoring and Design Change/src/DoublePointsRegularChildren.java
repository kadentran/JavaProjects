
// A frequent rental point computation that gives double regular points to any
// customer who is renting both regular and children movies
public class DoublePointsRegularChildren implements FrequentPoints {

    @Override
    public Integer getPoints(ShoppingCart cart) {
        Boolean hasChildrensMovie = false;
        Boolean hasRegularMovie = false;
        Integer totalPoints = 0;

        for (ShoppingCartItem item : cart.getItems()) {
            totalPoints += item.getPoints();

            if (!isMovieRental(item)) {
                continue;
            }

            MovieRental rental = (MovieRental) item;
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
    
    private boolean isMovieRental(ShoppingCartItem item) {
        if (item.getSalesCategory() != SalesCategory.RENTAL) {
            return false;
        }

        if (item.getItemType() != ItemType.MOVIE) {
            return false;
        }

        if (item instanceof NewRelease) {
            return false;
        }

        return true;
    }
}
