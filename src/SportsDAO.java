import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SportsDAO {
    MYSQLDatabase database;
    public SportsDAO(MYSQLDatabase database) {
        this.database = database;
        this.database = PolySportsDatabase.getInstance();
        this.database.loadDriver();
        this.database.connect();
    }
    public ArrayList<Sport> findAll(){
        Statement statement = this.database.createStatement();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sport;");
            ArrayList<Sport> sports = new ArrayList<>();
            while (resultSet.next()) {
                sports.add(new Sport(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("required_participants")));
            }
            return sports;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Sport findById(int id) {
        PreparedStatement statement = this.database.prepareStatement("SELECT * FROM sport WHERE id LIKE '%" + id + "%';");
        try { 
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Sport(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("required_participants"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Sport findByName(String name){
        Sport sport = null;
        PreparedStatement statement = this.database.prepareStatement("SELECT * FROM sport WHERE name LIKE '%" + name + "%';");
        try {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sport = new Sport(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("required_participants"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sport;
    }
}
