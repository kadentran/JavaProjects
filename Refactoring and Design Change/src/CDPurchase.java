public class CDPurchase extends Purchase {

    private final CD _cd;

    private CDPurchase (CD cd) {
        _cd = cd;
    }

    public static CDPurchase Create(CD cd) {
        return new CDPurchase(cd);
    }

    public CD getCD() {
        return _cd;
    }
    
    @Override
    public Double getPrice() {
        return 10.0;
    }

    @Override
    public Integer getPoints() {
        return 2;
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
