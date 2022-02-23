public class CD {

    private final String _title;
    private final CDTypes _cdType;

    public CD(String title, CDTypes cdType) {
        _title = title;
        _cdType = cdType;
    }

    public String getTitle() {
        return _title;
    }

    public CDTypes getType() {
        return _cdType;
    }
}
