package dbPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static DBConnection instance;
    private final Connection dbConnection;
    private final String dbUser;

    private DBConnection(String url, String dbUser, String dbPassword) throws SQLException {
        this.dbConnection = DriverManager.getConnection(url, dbUser, dbPassword);
        this.dbUser = dbUser;
    }

    public static DBConnection getInstance(String url, String dbUser, String dbPassword) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(url, dbUser, dbPassword);
        } else if (!instance.dbUser.equals(dbUser)) {
            System.out.println("Connection is open with different credentials");
        }
        return instance;
    }

    public static void closeConnection() throws SQLException {
        if (instance != null) {
            instance.getConnection().close();
        }
    }

    public Connection getConnection() {
        return this.dbConnection;
    }


}