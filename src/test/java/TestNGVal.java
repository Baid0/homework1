import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestNGVal {
    @Test
    public void valid() {


        try (Connection conn = MySQLUtil.getConnection();) {
            String selectSql = "SELECT COUNT(*) FROM students WHERE id = 1004";
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String phone = rs.getString("phone");


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}