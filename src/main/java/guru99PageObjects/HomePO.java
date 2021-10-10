package guru99PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePO {
    WebDriver driver;
    private static final String USERID_TEXTBOX = "//input[@name='uid']";
    private static final String PASSWORD_TEXTBOX = "//input[@name='password']";
    private static final String LOGIN_BUTTON = "//input[@name='btnLogin']";

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserIDTextbox(String mNG_USERID) {
        driver.findElement(By.xpath(USERID_TEXTBOX)).sendKeys(mNG_USERID);

    }
    public void enterPasswordTextbox(String mNG_PASSWORD) {
        driver.findElement(By.xpath(PASSWORD_TEXTBOX)).sendKeys(mNG_PASSWORD);
    }
    public void clickOnLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
}
