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

public class Logout extends BaseTest {
    WebDriver driver;
   // public Logout (WebDriver driver) {
     //   this.driver = driver;
    //}
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driver = new ChromeDriver();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.edge());
        Login login = new Login(driver);
        login.loginSuccessfully();
    }
    @Test
    public void logoutSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='float-right']//a[contains(text(),'Log out')]")).click();
        List<WebElement> element = driver.findElements(By.xpath("//ul[@class='float-right']/li/a"));

        Assertions.assertEquals(2, element.size());
        Assertions.assertEquals("REGISTER", element.get(0).getText());
        Assertions.assertEquals("LOG IN", element.get(1).getText());

    }
}
