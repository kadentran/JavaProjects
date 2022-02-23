public class CDRental extends Rental {
    private final CD _cd;
    private final int _daysRented;

    private CDRental(CD cd, int daysRented) {
        _cd      = cd;
        _daysRented = daysRented;
    }

    public static CDRental Create(CD cd, Integer daysRented) {
        return new CDRental(cd, daysRented);
    }

    public CD getCD() {
        return _cd;
    }

    @Override
    public Double getPrice() {
        return 5.0;
    }

    @Override
    public Integer getPoints() {
        return 1;
    }

    @Override
    public Integer getDaysRented() {
        return _daysRented;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.CD;
    }

    @Override
    public String getName() {
        return _cd.getTitle();
    }
    
}
