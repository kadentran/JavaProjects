public abstract class Rental implements ShoppingCartItem {
    abstract Integer getDaysRented();
    
    public SalesCategory getSalesCategory() {
        return SalesCategory.RENTAL;
    }
}
