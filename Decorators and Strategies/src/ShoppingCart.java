import java.util.List;

public interface ShoppingCart {
   Double calculateCost();

   Integer calculatePoints();
   
   void addRental(Rental rental);

   List<Rental> getRentals();
}
