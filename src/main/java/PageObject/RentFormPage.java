package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentFormPage {

    private WebDriver driver;

    public RentFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // поле дата
    private By date = By.xpath(".//div[@class='react-datepicker__input-container']/input");

    //поле "Срок аренды"
    private By period=By.className("Dropdown-placeholder");
    // поле "Срок аренды" - значение "сутки"
    private By period_1day=By.xpath(".//*[@class='Dropdown-option'][1]");
    // поле "Срок аренды" - значение "двое суток"
    private By period_2days=By.xpath(".//*[@class='Dropdown-option'][2]");
    // поле "Срок аренды" - значение "трое суток"
    private By period_3days=By.xpath(".//*[@class='Dropdown-option'][3]");
    // поле "Срок аренды" - значение "четверо суток"
    private By period_4days=By.xpath(".//*[@class='Dropdown-option'][4]");
    // поле "Срок аренды" - значение "пятеро суток"
    private By period_5days=By.xpath(".//*[@class='Dropdown-option'][5]");
    // поле "Срок аренды" - значение "шестеро суток"
    private By period_6days=By.xpath(".//*[@class='Dropdown-option'][6]");
    // поле "Срок аренды" - значение "семеро суток"
    private By period_7days=By.xpath(".//*[@class='Dropdown-option'][7]");

    // ввод даты
    public void inputDate(String newDate){
        driver.findElement(date).sendKeys(newDate);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }

    // выбор длительности аренды
    public void inputPeriod(int days){
        driver.findElement(period).click();
        if (days==1) {
            driver.findElement(period_1day).click();
        } else if (days==2) {
            driver.findElement(period_2days).click();
        } else if (days==3) {
            driver.findElement(period_3days).click();
        } else if (days==4) {
            driver.findElement(period_4days).click();
        } else if (days==5) {
            driver.findElement(period_5days).click();
        } else if (days==6) {
            driver.findElement(period_6days).click();
        } else if (days==7) {
            driver.findElement(period_7days).click();
        }
    }

    // конпка заказать
    private By done = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // нажать кнопку заказать
    public void onDone() {
        driver.findElement(done).click();
    }
     // кнопка в окне подтверждения заказа (да)
    private By doneModal = By.xpath(".//button[text()='Да' and @class='Button_Button__ra12g Button_Middle__1CSJM']");

    //подтвердить заказ (нажать кнопку да)
    public void onDoneModal() {
        driver.findElement(doneModal).click();
    }

    public void secondPageForm(String newDate,int days){
        inputDate(newDate);
        inputPeriod(days);
        onDone();
        onDoneModal();
    }
}
