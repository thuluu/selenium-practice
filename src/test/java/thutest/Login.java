package thutest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import vn.kms.course.selenium.bases.BaseTest;

import java.net.MalformedURLException;
import java.util.List;

public class Login extends BaseTest {
    WebDriver driver;
    public Login (WebDriver driver) {
        this.driver = driver;
    }
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driver = new ChromeDriver();

        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.edge());
    }
    @Test
    public void loginSuccessfully(){

        driver.get("https://demo.getsaleor.com/en/");
        driver.findElement(By.xpath("//ul[@class='float-right']//a[contains(text(),'Log in')]")).click();

        driver.findElement(By.id("id_username")).clear();
        driver.findElement(By.id("id_username")).sendKeys("admin@example.com");
        driver.findElement(By.id("id_password")).clear();
        driver.findElement(By.id("id_password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        List<WebElement> element = driver.findElements(By.xpath("//ul[@class='float-right']/li/a"));

        Assertions.assertEquals(3, element.size());
        Assertions.assertEquals("DASHBOARD", element.get(0).getText());
        Assertions.assertEquals("YOUR ACCOUNT", element.get(1).getText());
        Assertions.assertEquals("LOG OUT", element.get(2).getText());
    }
}
