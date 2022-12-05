package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentFormPage {

    private WebDriver driver;

    public RentFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // поле (*Когда привезти самокат)
    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // выпадает календарь
    public void onClickDate() {
        driver.findElement(date).click();
    }

    // кнопка 22 числа в календаре
    private By calendar = By.cssSelector(".react-datepicker__day--022");

    // нажатие кнопки 22 числа
    public void onClickCalendar() {
        driver.findElement(calendar).click();
    }

    // поле (*срок аренды)
    private By listPeriod = By.cssSelector(".Dropdown-placeholder");

    // выпадает список дней
    public void onClickListPeriod() {
        driver.findElement(listPeriod).click();
    }

    // 5 суток
    private By period = By.xpath(".//div[text()='пятеро суток']");

    // выбрать 5 суток
    public void onClickPeriod() {
        driver.findElement(period).click();
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
}
