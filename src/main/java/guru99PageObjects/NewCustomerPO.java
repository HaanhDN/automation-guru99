package guru99PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NewCustomerPO {
    WebDriver driver;
    public static final String CUSTOMER_NAME_TEXTBOX = "//td[text()='Customer Name']/parent::tr//input[@name='name']";
    public static final String CUSTOMER_NAME_ERROR_MESSAGE = "//td[text()='Customer Name']/parent::tr//label[@id='message']";
    public static final String ADDRESS_TEXTBOX = "//td[text()='Address']/parent::tr//textarea[@name='addr']";
    public static final String ADDRESS_ERROR_MESSAGE = "//td[text()='Address']/parent::tr//label[@id='message3']";
    public static final String PIN_TEXTBOX = "//td[text()='PIN']/parent::tr//input[@name='pinno']";
    public static final String PIN_ERROR_MESSAGE = "//td[text()='PIN']/parent::tr//label[@id='message6']";


    public NewCustomerPO(WebDriver driver) {
        this.driver = driver;
    }

    public void pressTABKeyOnNameTextbox() {
        driver.findElement(By.xpath(CUSTOMER_NAME_TEXTBOX)).sendKeys(Keys.TAB);
    }

    public Object getCustomerNameErrorMessage() {
        return driver.findElement(By.xpath(CUSTOMER_NAME_ERROR_MESSAGE)).getText();
    }

    public void inputCustomerNameTextbox(String customerName) {
        driver.findElement(By.xpath(CUSTOMER_NAME_TEXTBOX)).clear();
        driver.findElement(By.xpath(CUSTOMER_NAME_TEXTBOX)).sendKeys(customerName);
    }

    public void inputAddressTextbox(String address) {
        driver.findElement(By.xpath(ADDRESS_TEXTBOX)).clear();
        driver.findElement(By.xpath(ADDRESS_TEXTBOX)).sendKeys(address);
    }

    public Object getAddressErrorMessage() {
        return driver.findElement(By.xpath(ADDRESS_ERROR_MESSAGE)).getText();
    }

    public void inputPINTextbox(String PIN) {
        driver.findElement(By.xpath(PIN_TEXTBOX)).clear();
        driver.findElement(By.xpath(PIN_TEXTBOX)).sendKeys(PIN);
    }

    public Object getPINErrorMessage() {
        return driver.findElement(By.xpath(PIN_ERROR_MESSAGE)).getText();
    }

    public void pressTABKeyOnAddressTextbox() {
        driver.findElement(By.xpath(ADDRESS_TEXTBOX)).sendKeys(Keys.TAB);
    }
}
