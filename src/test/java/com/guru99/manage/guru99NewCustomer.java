package com.guru99.manage;

import guru99PageObjects.HomePO;
import guru99PageObjects.ManagerHomePO;
import guru99PageObjects.NewCustomerPO;
import guru99PageObjects.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import logs.logHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class guru99NewCustomer {
    private static Logger log = logHelper.getLogger();
    private static String MNG_USERID = "mngr357980";
    private static String MNG_PASSWORD = "demeqAm";
    private static final String GURU99BANK_HOME_URL = "http://demo.guru99.com/v4/index.php";
    WebDriver driver;
    HomePO homePage;
    ManagerHomePO managerHomePage;
    NewCustomerPO newCustomerPage;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        log.debug("Init WebDriver");

        driver = new ChromeDriver();
        log.info("Init Webdriver success");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(GURU99BANK_HOME_URL);
        homePage = PageGeneratorManager.getHomePO(driver);
        log.info("Pre-condition Step 01: Navigate to Guru99 Bank Home page");

        homePage.enterUserIDTextbox(MNG_USERID);
        log.info("Pre-condition Step 02: Enter UserID textbox with value " + MNG_USERID + "");

        homePage.enterPasswordTextbox(MNG_PASSWORD);
        log.info("Pre-condition Step 03: Enter Password textbox with value " + MNG_PASSWORD + "");

        homePage.clickOnLoginButton();
        log.info("Pre-condition Step 04: Click on Login button");

        managerHomePage = PageGeneratorManager.getManagerHomePO(driver);
        log.info("Pre-condition Step 05: Navigate to Manager Home page");

        Assert.assertEquals(managerHomePage.getWelcomeMessage(), "Welcome To Manager's Page of Guru99 Bank");
        log.info("Pre-condition Step 06: Verify manager welcome message displayed");

        managerHomePage.clickOnNewCustomerOnSubNavMenu();
        newCustomerPage = PageGeneratorManager.getNewCustomerPO(driver);
        log.info("Pre-condition Step 07: Navigate to New Customer form");
    }

    @Test
    public void TC_01_VerifyNameField_Empty() {
        newCustomerPage.pressTABKeyOnNameTextbox();
        log.info("VerifyNameField_Empty - Step 01: Press TAB key on 'Customer Name' textbox");

        Assert.assertEquals(newCustomerPage.getCustomerNameErrorMessage(), "Customer name must not be blank");
        log.info("VerifyNameField_Empty - Step 02: Verify error message displayed on 'Customer Name' textbox");

    }

    @Test
    public void TC_02_VerifyNameField_Numeric() {
        newCustomerPage.inputCustomerNameTextbox("name1234");
        log.info("VerifyNameField_Numeric - Step 01: Enter 'Customer Name' textbox with value "+ "name1234" + "");

        Assert.assertEquals(newCustomerPage.getCustomerNameErrorMessage(), "Numbers are not allowed");
        log.info("VerifyNameField_Numeric - Step 02: Verify error message displayed on 'Customer Name' textbox");
    }

    @Test
    public void TC_03_VerifyNameField_Special_Chars() {
        newCustomerPage.inputCustomerNameTextbox("name!@#");
        log.info("VerifyNameField_Special_Chars - Step 01: Enter 'Customer Name' textbox with value "+ "name!@#" + "");

        Assert.assertEquals(newCustomerPage.getCustomerNameErrorMessage(), "Special characters are not allowed");
        log.info("VerifyNameField_Special_Chars - Step 02: Verify error message displayed on 'Customer Name' textbox");

    }

    @Test
    public void TC_04_VerifyAddressField_Empty_First_Char() {
        newCustomerPage.inputAddressTextbox(" abc");
        log.info("VerifyAddressField_Empty_First_Char - Step 01: Enter 'Address' textbox with value "+ " abc" + "");

        Assert.assertEquals(newCustomerPage.getAddressErrorMessage(), "First character can not have space");
        log.info("VerifyAddressField_Empty_First_Char - Step 02: Verify error message displayed on 'Address' textbox");
    }



    @Test
    public void TC_05_VerifyAddressField_Empty() {
        newCustomerPage.pressTABKeyOnAddressTextbox();
        log.info("VerifyAddressField_Empty - Step 01: Press TAB key on Address Textbox");

        Assert.assertEquals(newCustomerPage.getAddressErrorMessage(), "First character can not have space");
        log.info("VerifyAddressField_Empty - Step 02: Verify error message displayed on 'Address' textbox");
    }

    @Test
    public void TC_06_VerifyPINField_Numeric_PIN() {
        newCustomerPage.inputPINTextbox("123PIN");
        log.info("VerifyPINField_Numeric_PIN - Step 01: Enter 'PIN' textbox with value "+ "123PIN" + "");

        Assert.assertEquals(newCustomerPage.getPINErrorMessage(), "Characters are not allowed");
        log.info("VerifyPINField_Numeric_PIN - Step 02: Verify error message displayed on 'PIN' textbox");

    }
    @Test
    public void TC_07_VerifyPINField_6_Digits_PIN() {
        newCustomerPage.inputPINTextbox("123");
        log.info("VerifyPINField_6_Digits_PIN - Step 01: Enter 'PIN' textbox with value "+ "123" + "");

        Assert.assertEquals(newCustomerPage.getPINErrorMessage(), "PIN Code must have 6 Digits");
        log.info("VerifyPINField_6_Digits_PIN - Step 02: Verify error message displayed on 'PIN' textbox");

    }
    @AfterClass
    public void afterClass() {
        driver.quit();

    }
}
