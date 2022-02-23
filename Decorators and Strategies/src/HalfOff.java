
public class HalfOff extends CouponDiscount {

    @Override
    public Double getDiscount(Double balance) {
        return balance * 0.5;
    }

    @Override
    public String description() {
        return "Half-off coupon";
    }
}
