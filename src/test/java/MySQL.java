import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class MySQL {
    WebDriver driver;
    @BeforeTest
    public void  setUp(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(ops);
    }
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try (FileInputStream f = new FileInputStream("C:\\Users\\Sopi\\IdeaProjects\\dataDriverFramework-homework\\src\\main\\resources\\db.properties")) {
            Properties pros = new Properties();
            pros.load(f);
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            conn = DriverManager.getConnection(url, user, password);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }   return conn;
    }

  @Test
public void db() throws SQLException {
    Connection conn = MySQL.getConnection();

    System.out.println(String.format("Connected to database %s "
            + "successfully.", conn.getCatalog()));

    }
  @Test
  public static void  Open(){
        open("https://demoqa.com/automation-practice-form");
  }


}

