
public class TenDollarOff extends CouponDiscount {

    @Override
    public Double getDiscount(Double balance) {
        if (balance > 10.0) {
            return 10.0;
        }
        return 0.0;
    }

    @Override
    public String description() {
        return "$10 off coupon";
    }
}
