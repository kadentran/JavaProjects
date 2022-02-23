public abstract class PointsDiscount implements Discount{
    protected ShoppingCart _cart;
    protected Customer _cust;

    public PointsDiscount(ShoppingCart cart, Customer cust) {
        _cart = cart;
        _cust = cust;
    }
}
