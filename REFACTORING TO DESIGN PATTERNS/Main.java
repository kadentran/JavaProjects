
public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Fred");

        c.addRental(Rental.Create(new Movie("The Matrix", Movie.REGULAR), 2));
        c.addRental(Rental.Create(new Movie("Regular Late Fee", Movie.REGULAR), 5));
        c.addRental(Rental.Create(new Movie("Alladin", Movie.CHILDRENS), 1));
        c.addRental(Rental.Create(new Movie("Children's Late Fee", Movie.CHILDRENS), 5));
        c.addRental(Rental.Create(new Movie("TENET", Movie.NEW_RELEASE), 5));

        System.out.println(c.statement());
    }
}

/*

Rental Record for Fred
        The Matrix              2.0
        Regular Late Fee        6.5
        Alladin                 1.5
        Children's Late Fee     4.5
        TENET                   15.0
Amount owed is 29.5
You earned 6 frequent renter points

*/