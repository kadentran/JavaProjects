import java.util.List;

public interface ShoppingCart {
   Double getTotal();

   Integer getPoints();
   
   void addItem(ShoppingCartItem item);

   List<ShoppingCartItem> getItems();
}
