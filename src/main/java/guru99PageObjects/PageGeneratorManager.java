package guru99PageObjects;
import org.openqa.selenium.WebDriver;
public class PageGeneratorManager {
        public static HomePO getHomePO(WebDriver driver) {
            return new HomePO(driver);
        }
        public static ManagerHomePO getManagerHomePO(WebDriver driver) {
            return new ManagerHomePO(driver);
        }
        public static NewCustomerPO getNewCustomerPO(WebDriver driver) {
            return new NewCustomerPO(driver);
        }
}
