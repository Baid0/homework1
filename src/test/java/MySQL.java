import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(ops);
    }





    @Test
    public void insertRow() {

        try (Connection conn = MySQLUtil.getConnection();) {
            String insertSql = "INSERT INTO students (id, firstName, lastName, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertSql);

            conn.setAutoCommit(false);
            insertStatement.setInt(1, 1005);
            insertStatement.setString(2, "Sophi");
            insertStatement.setString(3, "Sologhashvili");
            insertStatement.setString(4, "555555555");

            insertStatement.executeUpdate();


            String selectSql = "SELECT COUNT(*) FROM students WHERE id = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectSql);
            selectStatement.setInt(1, 1005);
            ResultSet rs = selectStatement.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}




