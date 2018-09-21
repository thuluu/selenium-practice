package thutest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import thutest.Login;
import vn.kms.course.selenium.bases.BaseTest;

import java.net.MalformedURLException;

public class AddToCart extends BaseTest {
    WebDriver driver;
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driver = new ChromeDriver();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.edge());
        Login login = new Login(driver);
        login.loginSuccessfully();
    }
    @Test
    public void validateaddtocartfeature(){
        driver.findElement(By.xpath("//a[@class='nav-link' and contains(text(),'Apparel')]")).click();
        driver.findElement(By.xpath("(//div[@class='text-center']//img)[1]")).click();
        driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("3");
        driver.findElement(By.xpath("//label[contains(text(),'M')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    }
}
