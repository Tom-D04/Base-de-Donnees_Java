import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MYSQLDatabase {
    private final String host;
    private final int port;
    private final String databaseName;
    private final String user;
    private final String password;
    private Connection connection;
    private static boolean driverLoaded;

    public MYSQLDatabase(String host, int port, String databaseName, String user, String password) {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
        this.connection = null;
        MYSQLDatabase.driverLoaded = false;
    }
    public void connect() {
        try {
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?allowMultiQueries=true",
                user,
                password
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    } 
    public Statement createStatement() {
        try {
            return connection.createStatement();
        } catch (Exception sqlException) {
            System.err.println(sqlException.getMessage());
            return null;
        }
    }
    public void loadDriver() {
        if (!driverLoaded){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                driverLoaded = true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public PreparedStatement prepareStatement(String query) {
        try {
            return connection.prepareStatement(query);
        } catch (Exception sqlException) {
            System.err.println(sqlException.getMessage());
            return null;
        }
    }
    
}
