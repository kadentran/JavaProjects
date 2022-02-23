public class SouvenirPurchase extends Purchase {

    private final Souvenir _souvenir;

    private SouvenirPurchase (Souvenir souvenir) {
        _souvenir = souvenir;
    }

    public static SouvenirPurchase Create(Souvenir _souvenir) {
        return new SouvenirPurchase(_souvenir);
    }

    public Souvenir getSouvenir() {
        return _souvenir;
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
        return ItemType.SOUVENIR;
    }

    @Override
    public String getName() {
        return _souvenir.getTitle();
    }
}