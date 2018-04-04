package vn.kms.course.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vn.kms.course.selenium.bases.BasePage;

import java.util.List;

public class SamplePage extends BasePage {
    public SamplePage(WebDriver webDriver) {
        super(webDriver);
        this.path = "/samplePage";
    }

    @FindBy(css = "#sampleElement")
    WebElement sampleElement;

    @FindBy(className = "sampleList")
    List<WebElement> sampleListElements;

    public void clickSampleElement(){
        sampleElement.click();
    }

    public int getSampleListSize(){
        return sampleListElements.size();
    }
}
