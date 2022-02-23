public class Souvenir {
    private final String _title;
    private final SouvenirTypes _souvenirType;

    public Souvenir(String title, SouvenirTypes souvenirType) {
        _title = title;
        _souvenirType = souvenirType;
    }

    public String getTitle() {
        return _title;
    }

    public SouvenirTypes getType() {
        return _souvenirType;
    }  
}
