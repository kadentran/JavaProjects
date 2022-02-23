

public class RegularMoviePurchaseCostCalculator extends PurchaseCostCalculator{

    @Override
    public Double calculate(Purchase item) {
        return 10.0;
    }
}
