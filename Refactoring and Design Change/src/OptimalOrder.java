import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Apply discounts in an order that provides the largest benefit to the customer.
public class OptimalOrder implements DiscountOrder {

    @Override
    public Double getDiscount(List<Discount> discounts, Double balance) {
        List<List<Discount>> permutations = permute(discounts, 0, discounts.size() - 1);
        Double totalDiscount = getMaxDiscount(permutations, balance);

        if (totalDiscount > balance) {
            return balance;
        } else {
            return totalDiscount;
        }
    }

    private Double getMaxDiscount(List<List<Discount>> permutations, Double balance) {
        Double maxDiscount = 0.0;

        for (List<Discount> permutation : permutations) {
            maxDiscount = Math.max(applyDiscounts(permutation, balance), maxDiscount);
        }

        return maxDiscount;
    }

    private Double applyDiscounts(List<Discount> discounts, Double balance) {
        Double totalDiscount = 0.0;

        for (Discount discount : discounts) {
            totalDiscount += discount.getDiscount(balance - totalDiscount);
        }

        return totalDiscount;
    }
    
    private <T> List<List<T>> permute(List<T> items, Integer start, Integer end) {
        List<List<T>> result = new ArrayList<List<T>>();

        if (start == end) {
            result.add(new ArrayList<T>(items));
        } else {
            for (Integer i = start; i <= end; i++) {
                Collections.swap(items, start, i);
                result.addAll(permute(items, start + 1, end));
                Collections.swap(items, start, i);
            }
        }

        return result;
    }
}
