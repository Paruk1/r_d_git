package dbPackage;

import org.testng.annotations.AfterSuite;

import java.sql.Connection;
import java.sql.SQLException;


public class BaseTest {
    public static final String dbAdderss = "jdbc:postgresql://localhost:5432/paruk";
    public static final String dbUser = "test";
    public static final String dbPassword = "test";


    protected Connection getConnection() throws SQLException {
        return DBConnection.getInstance(dbAdderss, dbUser, dbPassword).getConnection();
    }

    @AfterSuite
    public void tearDown() {
        try {
            DBConnection.closeConnection();
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }
}
