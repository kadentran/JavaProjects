public abstract class Purchase implements ShoppingCartItem {
    public SalesCategory getSalesCategory() {
        return SalesCategory.PURCHASE;
    }
}
