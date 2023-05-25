import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCQuerying {


//        public static Connection getConnection() throws SQLException {
//        Connection conn = null;
//        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
//        Properties pros = new Properties();
//        pros.load(f);
//        String url = pros.getProperty("url");
//        String user = pros.getProperty("user");
//        String password = pros.getProperty("password");
//        conn = DriverManager.getConnection(url, user, password);
//
//        } catch (IOException e) {
//        System.out.println(e.getMessage());
//        }
//        return conn;
//        }


        @Test
        public void insertRow() {

                try (Connection conn = MySQLUtil.getConnection();) {
                        String insertSql = "INSERT INTO students (id, firstName, lastName, phone) VALUES (?, ?, ?, ?)";
                        PreparedStatement insertStatement = conn.prepareStatement(insertSql);

                        conn.setAutoCommit(true);
                        insertStatement.setInt(1, 1004);
                        insertStatement.setString(2, "Sophi");
                        insertStatement.setString(3, "Sologhashvili");
                        insertStatement.setString(4, "555555555");

                        insertStatement.executeUpdate();

                        String selectSql = "SELECT COUNT(*) FROM students WHERE id = ?";
                        PreparedStatement selectStatement = conn.prepareStatement(selectSql);
                        selectStatement.setInt(1, 1004);
                        ResultSet rs = selectStatement.executeQuery();
                        rs.next();
                        int rowCount = rs.getInt(1);
                }

                catch (SQLException e) {
                        throw new RuntimeException(e);
                }


        }
}




