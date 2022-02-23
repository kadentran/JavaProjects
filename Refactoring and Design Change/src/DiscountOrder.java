import java.util.List;

// DiscountOrder defines a strategy used to control the order that discounts are applied in.
public interface DiscountOrder {
    Double getDiscount(List<Discount> discounts, Double balance);
}
