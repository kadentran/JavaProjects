

public class ChildrensMoviePurchaseCostCalculator extends PurchaseCostCalculator {

    @Override
    public Double calculate(Purchase item) {
        return 5.0;
    }

}
