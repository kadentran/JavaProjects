import java.util.List;

// Process discounts in the order in which they were added to the list provided.
public class FixedOrder implements DiscountOrder {

    @Override
    public Double getDiscount(List<Discount> discounts, Double balance) {
        Double totalDiscount = 0.0;
        Double individualDiscount = 0.0;

        for (Discount discount : discounts) {
            individualDiscount = discount.getDiscount(balance - totalDiscount);
            totalDiscount += individualDiscount;
        }

        if (totalDiscount > balance) {
            return balance;
        } else {
            return totalDiscount;
        }
    }
}
