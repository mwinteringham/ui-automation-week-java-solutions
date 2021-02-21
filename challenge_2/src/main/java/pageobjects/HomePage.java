package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(how = How.CSS, using = ".openBooking")
    private WebElement btnOpenBooking;

    @FindBy(how = How.CSS, using = ".btn-outline-primary.book-room")
    private WebElement btnSubmitBooking;

    @FindBy(how = How.CSS, using = ".alert-danger")
    private WebElement divAlert;

    @FindBy(how = How.ID, using = "name")
    private WebElement inptName;

    @FindBy(how = How.ID, using = "email")
    private WebElement inptEmail;

    @FindBy(how = How.ID, using = "phone")
    private WebElement inpPhone;

    @FindBy(how = How.ID, using = "subject")
    private WebElement inptSubject;

    @FindBy(how = How.ID, using = "description")
    private WebElement txtAreaDescription;

    @FindBy(how = How.ID, using = "submitContact")
    private WebElement btnSubmit;

    @FindBy(how = How.CSS, using = ".contact h2")
    private WebElement divDisplayMessage;

    public HomePage(WebDriver driver) {
        super(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".openBooking")));
    }

    public void clickOpenBookingForm() {
        btnOpenBooking.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rbc-calendar")));
    }

    public void clickSubmitBooking() {
        btnSubmitBooking.click();
    }


    public Boolean bookingFormErrorsExist() {
        return divAlert.isDisplayed();
    }

    public void setContactFormName(String name) {
        inptName.sendKeys(name);
    }

    public void setContactFormEmail(String email) {
        inptEmail.sendKeys(email);
    }

    public void setContactFormPhone(String phoneNumber) {
        inpPhone.sendKeys(phoneNumber);
    }

    public void setContactFormSubject(String subject) {
        inptSubject.sendKeys(subject);
    }

    public void setContactFormDescription(String description) {
        txtAreaDescription.sendKeys(description);
    }

    public void clickContactFormSubmit() {
        btnSubmit.click();
    }

    public String getResponseText() {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.visibilityOf(divDisplayMessage));

        return divDisplayMessage.getText();
    }
}
