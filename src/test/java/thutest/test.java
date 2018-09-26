package thutest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vn.kms.course.selenium.bases.BaseTest;

import java.net.MalformedURLException;
import java.util.Random;

public class test extends BaseTest {
  //  public static void main (String arg[]) {
  //      String fullprice = "$123.1234\n";
    //    String fullprice1 = fullprice.replaceAll("\\$", "").replaceAll("\n","");
      // double price = Double.parseDouble(fullprice1);

       //price++;
        //System.out.println(price);
    //}
       WebDriver driver;
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driver = new ChromeDriver();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.edge());
        Login login = new Login(driver);
        login.loginSuccessfully();
    }

    @Test
    public void validateaddtocartfeature() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='nav-link' and contains(text(),'Apparel')]")).click();
        int totalElement = driver.findElements(By.xpath("//div[@class='text-center']//img")).size();

        Random x = new Random();
        int rand = x.nextInt(totalElement);

        //select random product
        driver.findElement(By.xpath("(//div[@class='text-center']//img)["+rand+"]")).click();

        //get product name
        String product = driver.findElement(By.xpath("//h1[@class='product__info__name']")).getText();

        //enter random quantity
        driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys(rand+"");

        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        Thread.sleep(3000);
        //navigate to cart page
        driver.findElement(By.xpath("//div[@class='navbar__brand__cart__icon']")).click();
        driver.findElement(By.xpath("//div[@class='cart']//p[contains(text(),'"+rand+"')]"));

    }
}
