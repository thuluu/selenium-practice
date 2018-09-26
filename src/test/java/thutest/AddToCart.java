package thutest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import thutest.Login;
import vn.kms.course.selenium.bases.BaseTest;

import java.net.MalformedURLException;
import java.util.Random;

public class AddToCart extends BaseTest {
    WebDriver driver;
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driver = new ChromeDriver();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.edge());
        Login login = new Login(driver);
        login.loginSuccessfully();
    }
    @RepeatedTest(1)
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
        //calculate price
        String fullPrice = driver.findElement(By.xpath("//h2[@class='product__info__price']//span")).getText();
        fullPrice = fullPrice.replaceAll("\\$", "").replaceAll("\\n","").replaceAll(" ","");
        double price = Double.parseDouble(fullPrice);
        double a = Math.round(price*rand*100);
        double totalPrice = a/100;

        driver.findElement(By.xpath("//label[contains(text(),'M')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        Thread.sleep(3000);
        //navigate to cart page
        driver.findElement(By.xpath("//div[@class='navbar__brand__cart__icon']")).click();
        //driver.findElement(By.xpath("//div[@class='cart']//p[contains(text(),'"+rand+"')]"));

        //check price
        String fullPrice1 = driver.findElement(By.xpath("//p[@class='text-right']")).getText();
        fullPrice1 = fullPrice1.replaceAll("\\$", "").replaceAll("\\n", "");
        double totalPrice1 = Double.parseDouble(fullPrice1);

        Assertions.assertEquals(totalPrice,totalPrice1);

        //check number of item
        int randCheck = Integer.parseInt(driver.findElement(By.id("id_quantity")).getAttribute("value"));
        Assertions.assertEquals(rand,randCheck);

        //check name of product
        driver.findElement(By.xpath("//p[contains(text(),'"+product+"')]"));
    }
}
