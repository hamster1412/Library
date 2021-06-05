package newpackage;

import java.sql.Statement;
import static newpackage.Connection.connect;
import java.sql.*;

public class Create {
    public static void create() {
        try {
            Connection connection = connect();
            ResultSet resultSet = connection.getMetaData().getCatalogs();
            while ( resultSet.next() ){
                String databaseName = resultSet.getString(1);
                if ( databaseName.equals("library")) {
                    Statement statement = connection.createStatement();
                    String sql = "DROP DATABASE library";
                    // statement.executeUpdate(sql);
                }
            }
            Statement statement = connection.createStatement();
            String database = "CREATE DATABASE library";
            statement.executeUpdate(database);
            statement.executeUpdate("USE library");
            String user_table = "CREATE TABLE USERS(user)";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}