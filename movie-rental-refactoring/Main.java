
public class Main {
    public static void main(String[] args) {

        Movie movie1 = new RegularMovie("The longest yard (Regular Movie)");
        Movie movie2 = new RegularMovie("The longest yard (Regular Late Fee)");
        Movie movie3 = new ChildrensMovie("Trolls World Tour (Children's Movie)");
        Movie movie4 = new ChildrensMovie("Trolls World Tour (Children's Late Fee)");
        Movie movie5 = new RegularMovie("Matrix 4 (New Release - Regular)");
        Movie movie6 = new RegularMovie("Scoob! (New Release - Children)");

        // Test customer 1
        Customer customer1 = new Customer("Fred");
        customer1.addRental(new StandardRental(movie1, 2));
        customer1.addRental(new StandardRental(movie2, 5));
        customer1.addRental(new StandardRental(movie3, 1));
        customer1.addRental(new StandardRental(movie4, 5));
        customer1.addRental(new NewReleaseRental(movie5, 5));
        customer1.addRental(new NewReleaseRental(movie6, 5));
        System.out.println(customer1.statement());
        System.out.println(customer1.statementXml());

        // Test customer 2
        Customer customer2 = new Customer("Chloe");
        customer2.addRental(new StandardRental(movie1, 1));
        customer2.addRental(new StandardRental(movie3, 3));
        customer2.addRental(new StandardRental(movie4, 7));
        customer2.addRental(new StandardRental(movie6, 4));

        System.out.println();
        System.out.println(customer2.statement());
        System.out.println(customer2.statementXml());
    }
}