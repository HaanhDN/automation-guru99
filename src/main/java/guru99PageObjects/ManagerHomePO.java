package guru99PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerHomePO {
    WebDriver driver;
    public static final String MANAGER_WELCOME_MESSAGE = "//marquee[@class='heading3']";
    public static final String SUB_NAV_MENU_NEW_CUSTOMER = "//ul[@class='menusubnav']//a[text()='New Customer']";

    public ManagerHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public Object getWelcomeMessage() {
        return driver.findElement(By.xpath(MANAGER_WELCOME_MESSAGE)).getText();
    }

    public void clickOnNewCustomerOnSubNavMenu() {
        driver.findElement(By.xpath(SUB_NAV_MENU_NEW_CUSTOMER)).click();
    }
}
