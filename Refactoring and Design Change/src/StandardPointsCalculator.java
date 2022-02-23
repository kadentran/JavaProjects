public class StandardPointsCalculator extends PointsCalculator {

    private static final Integer POINTS_PER_RELEASE = 1;

    @Override
    public Integer calculate(ShoppingCartItem rental) {
        return POINTS_PER_RELEASE;
    }
}
