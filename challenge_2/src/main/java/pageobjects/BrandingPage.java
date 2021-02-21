package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrandingPage extends BasePage {

    @FindBy(how = How.ID, using = "name")
    private WebElement inpName;

    @FindBy(how = How.CSS, using = ".btn-outline-primary")
    private WebElement btnUpdate;

    @FindBy(how = How.CSS, using = ".ReactModalPortal button")
    private WebElement btnDialog;

    public BrandingPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name){
        inpName.sendKeys(name);
    }

    public void clickUpdate(){
        btnUpdate.click();
    }

    public boolean isPopupDisplayed() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2000);
        webDriverWait.until(ExpectedConditions.visibilityOf(btnDialog));

        return btnDialog.isDisplayed();
    }
}
