package dbPackage;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBTest extends BaseTest {

    @Test
    public void testConnectionToBD() throws SQLException {
        String sqlSelect = "select * from test where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlSelect);
        preparedStatement.setLong(1,529);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            System.out.println(resultSet.getString("amount"));
        }
        String sqlUpdate = "update test set amount = 123 where id = ?";
        PreparedStatement preparedStatementUpdate = getConnection().prepareStatement(sqlUpdate);
        preparedStatementUpdate.setLong(1,529);
        preparedStatementUpdate.executeUpdate();

        String sqlDelete = "delete from testnew where id = ?";
        PreparedStatement preparedStatementDelete = getConnection().prepareStatement(sqlDelete);
        preparedStatementDelete.setLong(1,555);
        preparedStatementDelete.executeUpdate();

        String sqlInsert = "insert into erortable values (532,'ERROR','2023-12-01',0,'2022-04-27 14:38:33',199121)";
        PreparedStatement preparedStatementInsert = getConnection().prepareStatement(sqlInsert);
        preparedStatementInsert.executeUpdate();
    }

}