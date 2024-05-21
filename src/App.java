//import java.sql.ResultSet;
//import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        MYSQLDatabase db = PolySportsDatabase.getInstance();
        db.loadDriver();
        db.connect();
        SportsDAO sportsDAO = new SportsDAO(db);
        System.out.println(sportsDAO.findByName());
    }
}






















/*       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/poly_sports",
            "TOM",
            "123"
            );
            Statement myStatement = myConnection.createStatement();
            ResultSet results = myStatement.executeQuery("SELECT * FROM sport;");
            while(results.next())
            {
                System.out.println(results.getString("name"));
                System.out.println(results.getString("required_participants"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    } */