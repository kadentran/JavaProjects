import java.util.ArrayList;
import java.util.List;

// Discounts is a 'decorator' around ShoppingCart that can
// apply a set of coupons to discount the cost of the movies in the cart.
public class Discounts implements ShoppingCart {

    private final List<Discount> _discountCalculators = new ArrayList<Discount>();
    private final ShoppingCart _cart;
    private DiscountOrder _order;

    public Discounts(ShoppingCart cart, DiscountOrder order) {
        _cart = cart;
        _order = order;
    }

    public void setDiscountOrder(DiscountOrder order) {
        _order = order;
    }

    public void add(Discount discountCalculator) {
        if (discountCalculator == null) {
            throw new IllegalArgumentException("Discount calculator cannot be null");
        }
        
        _discountCalculators.add(discountCalculator);
    }

    @Override
    public Double calculateCost() {
        Double balance = _cart.calculateCost();
        Double totalDiscounts = _order.getDiscount(_discountCalculators, balance);

        return balance - totalDiscounts;
    }

    @Override
    public void addRental(Rental rental) {
        _cart.addRental(rental);
    }

    @Override
    public Integer calculatePoints() {
        return _cart.calculatePoints();
    }

    @Override
    public List<Rental> getRentals() {
        return _cart.getRentals();
    }
}
