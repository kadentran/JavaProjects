public interface ShoppingCartItem {
    Double getPrice();
    Integer getPoints();
    SalesCategory getSalesCategory();
    ItemType getItemType();
    String getName();
}
