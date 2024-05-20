public class PolySportsDatabase extends MYSQLDatabase{
    private static PolySportsDatabase instance;
    private PolySportsDatabase() {
        super("localhost", 3306, "poly_sports", "TOM", "123");
        PolySportsDatabase.instance = null;
    }
    public static PolySportsDatabase getInstance() {
        if (PolySportsDatabase.instance == null) {
            PolySportsDatabase.instance = new PolySportsDatabase();
        }
        return PolySportsDatabase.instance;
    }
}
