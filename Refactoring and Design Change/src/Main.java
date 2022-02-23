public class Main {
    public static void main(String[] args) {
        testNewRelease();
        testDiscounts();
        testPoints();
        testAddDifferentItemTypes();
    }

    static void testAddDifferentItemTypes() {
        System.out.println("Testing adding different types of items");
        ShoppingCart cart = new ShoppingCartImpl(new DoublePointsRegularChildren());
        
        cart.addItem(MoviePurchase.Create(new Movie("MyNewMovie", MovieTypes.REGULAR)));

        cart.addItem(MovieRental.Create(new Movie("Regular1", MovieTypes.REGULAR), 2));
        cart.addItem(MovieRental.Create(new Movie("Regular2 Late Fee", MovieTypes.REGULAR), 5));
        cart.addItem(MovieRental.Create(new Movie("Childrens1", MovieTypes.CHILDRENS), 1));
        cart.addItem(MovieRental.Create(new Movie("Childrens Late Fee", MovieTypes.CHILDRENS), 5));
        cart.addItem(new NewRelease(MovieRental.Create(new Movie("Regular3 New Release", MovieTypes.REGULAR), 5)));

        cart.addItem(CDRental.Create(new CD("The White Album", CDTypes.POP), 3));
        cart.addItem(CDPurchase.Create(new CD("Holiday Music", CDTypes.SEASONAL)));

        cart.addItem(SouvenirPurchase.Create(new Souvenir("Commemorative Flag", SouvenirTypes.FLAG)));

        expect(64.5, cart.getTotal());
    }

    static void testDiscounts() {
        Customer cust = new Customer("Fred", 20, 120);
        ShoppingCart cart = new ShoppingCartImpl(new DoublePointsRegularChildren());

        // Apply discounts in a fixed order
        Discounts discounts = new Discounts(cart, new FixedOrder());

        discounts.add(new FreeMovie(cart, cust));
        discounts.add(new HalfOff());
        discounts.add(new TenDollarOff());

        System.out.println("Testing discount calculator");

        addMoreThan50DollarsToCart(cart);

        expect(79.0, cart.getTotal());
        expect(22.0, discounts.getTotal());

        // Use optimal order for calculating discounts
        discounts.setDiscountOrder(new OptimalOrder());
        expect(14.5, discounts.getTotal());

        // Check points calculation for each type of strategy
        expect(24, cart.getPoints());
    }

    static void testPoints() {
        testDoublePointsRegularChildrenStrategy();
        testDoublePointsNewReleaseStrategy();
    }

    private static void testDoublePointsNewReleaseStrategy() {
        Customer cust = new Customer("Fred", 20, 120);
        ShoppingCart cart = new ShoppingCartImpl(new DoublePointsNewRelease(cust));

        System.out.println("Testing DoublePointsNewRelease calculator");

        addMoreThan50DollarsToCart(cart);

        expect(24, cart.getPoints());
    }

    private static void testDoublePointsRegularChildrenStrategy() {
        ShoppingCart cart = new ShoppingCartImpl(new DoublePointsRegularChildren());

        System.out.println("Testing DoublePointsRegularChildren calculator");

        addMoreThan50DollarsToCart(cart);

        expect(24, cart.getPoints());
    }

    static void testNewRelease() {
        ShoppingCart cart = new ShoppingCartImpl(new DoublePointsRegularChildren());
        ShoppingCartItem newRelease = new NewRelease(MovieRental.Create(new Movie("Regular2 New Release", MovieTypes.REGULAR), 5));
        cart.addItem(newRelease);

        expect(15.0, cart.getTotal());
        expect(2, cart.getPoints());
    }


    static void addMoreThan50DollarsToCart(ShoppingCart cart) {
        addLessThan50DollarsToCart(cart);
        addLessThan50DollarsToCart(cart);
    }

    static void addLessThan50DollarsToCart(ShoppingCart cart) {
        cart.addItem(MoviePurchase.Create(new Movie("MyNewMovie", MovieTypes.REGULAR)));
        cart.addItem(MovieRental.Create(new Movie("Regular1", MovieTypes.REGULAR), 2));
        cart.addItem(MovieRental.Create(new Movie("Regular2 Late Fee", MovieTypes.REGULAR), 5));
        cart.addItem(MovieRental.Create(new Movie("Childrens1", MovieTypes.CHILDRENS), 1));
        cart.addItem(MovieRental.Create(new Movie("Childrens Late Fee", MovieTypes.CHILDRENS), 5));
        cart.addItem(new NewRelease(MovieRental.Create(new Movie("Regular3 New Release", MovieTypes.REGULAR), 5)));
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
