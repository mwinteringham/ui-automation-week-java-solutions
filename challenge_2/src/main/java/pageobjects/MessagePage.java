package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MessagePage extends BasePage {

    @FindBy(how = How.CSS, using = ".read-false")
    List<WebElement> divUnreadMessages;

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getBoldedMessages() {
        return divUnreadMessages;
    }
}
