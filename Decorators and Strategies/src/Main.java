public class Main {
    public static void main(String[] args) {
        testNewRelease();
        testDiscounts();
        testPoints();
    }

    static void testDiscounts() {
        Customer cust = new Customer("Fred", 20, 120);
        ShoppingCart cart = new RentalShoppingCart(new DoublePointsRegularChildren());

        // Apply discounts in a fixed order
        Discounts discounts = new Discounts(cart, new FixedOrder());

        discounts.add(new FreeMovie(cart, cust));
        discounts.add(new HalfOff());
        discounts.add(new TenDollarOff());

        System.out.println("Testing discount calculator");

        addMoreThan50DollarsToCart(cart);

        expect(59.0, cart.calculateCost());
        expect(12.0, discounts.calculateCost());

        // Use optimal order for calculating discounts
        discounts.setDiscountOrder(new OptimalOrder());
        expect(4.5, discounts.calculateCost());

        // Check points calculation for each type of strategy
        expect(24, cart.calculatePoints());
    }

    static void testPoints() {
        testDoublePointsRegularChildrenStrategy();
        testDoublePointsNewReleaseStrategy();
    }

    private static void testDoublePointsNewReleaseStrategy() {
        Customer cust = new Customer("Fred", 20, 120);
        ShoppingCart cart = new RentalShoppingCart(new DoublePointsNewRelease(cust));

        System.out.println("Testing DoublePointsNewRelease calculator");

        addMoreThan50DollarsToCart(cart);

        expect(24, cart.calculatePoints());
    }

    private static void testDoublePointsRegularChildrenStrategy() {
        ShoppingCart cart = new RentalShoppingCart(new DoublePointsRegularChildren());

        System.out.println("Testing DoublePointsRegularChildren calculator");

        addMoreThan50DollarsToCart(cart);

        expect(24, cart.calculatePoints());
    }

    static void testNewRelease() {
        ShoppingCart cart = new RentalShoppingCart(new DoublePointsRegularChildren());
        Rental newRelease = new NewRelease(MovieRental.Create(new Movie("Regular2 New Release", MovieTypes.REGULAR), 5));
        cart.addRental(newRelease);

        expect(15.0, cart.calculateCost());
        expect(2, cart.calculatePoints());
    }


    static void addMoreThan50DollarsToCart(ShoppingCart cart) {
        addLessThan50DollarsToCart(cart);
        addLessThan50DollarsToCart(cart);
    }

    static void addLessThan50DollarsToCart(ShoppingCart cart) {
        cart.addRental(MovieRental.Create(new Movie("Regular1", MovieTypes.REGULAR), 2));
        cart.addRental(MovieRental.Create(new Movie("Regular2 Late Fee", MovieTypes.REGULAR), 5));
        cart.addRental(MovieRental.Create(new Movie("Childrens1", MovieTypes.CHILDRENS), 1));
        cart.addRental(MovieRental.Create(new Movie("Childrens Late Fee", MovieTypes.CHILDRENS), 5));
        cart.addRental(new NewRelease(MovieRental.Create(new Movie("Regular3 New Release", MovieTypes.REGULAR), 5)));
    }

    static void expect(Double expected, Double actual) {
        if (Double.compare(expected, actual) != 0) {
            throw new RuntimeException("Expected " + expected + " Actual: " + actual);
        }
    }

    static void expect(Integer expected, Integer actual) {
        if (Integer.compare(expected, actual) != 0) {
            throw new RuntimeException("Expected " + expected + " Actual: " + actual);
        }
    }

    static void expect(String expected, String actual) {
        if (expected.compareTo(actual) != 0) {
            throw new RuntimeException("\nExpected:\n" + expected + "\nActual:\n" + actual);
        }
    }
}

/*

This is sample expected output from one of the tests.

Rental Record for Fred
        The Matrix              2.0
        Regular Late Fee        6.5
        Alladin                 1.5
        Children's Late Fee     4.5
        TENET                   15.0
Amount owed is 29.5
You earned 6 frequent renter points

*/