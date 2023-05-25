import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateRow {
    @Test
    public void valid() {



        try (Connection conn = MySQLUtil.getConnection();) {
            String selectSql = "SELECT COUNT(*) FROM students WHERE id = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            selectStatement.setInt(1, 1004);
            ResultSet rs = selectStatement.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);
            if (rowCount == 0) {
                System.out.println("Row wasn't created.");
            }
            conn.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}