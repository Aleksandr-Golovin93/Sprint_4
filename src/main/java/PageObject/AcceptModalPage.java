package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AcceptModalPage {

    private WebDriver driver;

    public AcceptModalPage(WebDriver driver) {
        this.driver = driver;
    }

    // текст с номером заказа
    private By modalAccept = By.cssSelector(".Order_ModalHeader__3FDaJ");

    // получить текст с номером заказа
    public String getTitleAcceptModel() {
        return driver.findElement(modalAccept).getText();
    }
}
