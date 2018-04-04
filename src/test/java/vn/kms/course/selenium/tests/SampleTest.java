package vn.kms.course.selenium.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vn.kms.course.selenium.bases.BaseTest;
import vn.kms.course.selenium.pages.SamplePage;

public class SampleTest extends BaseTest{
    private WebDriver webDriver;
    @BeforeEach
    public void beforeEach(){
        webDriver = new ChromeDriver();
    }
    //Note: I put the annotation Disabled here since this test is just a sample, it's not runnable so we won't run it. When you write your real tests, don't put the Disabled.
    @Test
    @Disabled
    public void sampleTest(){
        SamplePage samplePage = new SamplePage(webDriver);
        samplePage.goToPage();
        samplePage.clickSampleElement();
        Assertions.assertEquals(5, samplePage.getSampleListSize());
    }
    @AfterEach
    public void afterEach(){
        webDriver.quit();
    }
}
