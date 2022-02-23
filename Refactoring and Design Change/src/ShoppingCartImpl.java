import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {

    private List<ShoppingCartItem> _items = new ArrayList<>();
    private final FrequentPoints _frequentPoints;

    public ShoppingCartImpl(FrequentPoints frequentPoints) {
        _frequentPoints = frequentPoints;
    }

    @Override
    public Double getTotal() {
        Double totalCost = 0.0;

        for (ShoppingCartItem item : _items) {
            Double rentalCost = item.getPrice();
            totalCost += rentalCost;
        }

        return totalCost;
    }

    @Override
    public void addItem(ShoppingCartItem rental) {
        _items.add(rental);
    }

    @Override
    public Integer getPoints() {
        return _frequentPoints.getPoints(this);
    }

    @Override
    public List<ShoppingCartItem> getItems() {
        return _items;
    }
}

