package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UserFormOrder {

    private WebDriver driver;

    public UserFormOrder(WebDriver driver) {
        this.driver = driver;
    }

    private By name = By.xpath(".//input[@placeholder='* Имя']"); // поле ввода Имя

    // ввод Имени
    public void setName (String userName) {
        driver.findElement(name).sendKeys(userName);
    }

    private By surname  = By.xpath(".//input[@placeholder='* Фамилия']"); // поле ввода Фамилия

    // ввод  Фамилии
    public void setSurname (String userSurname) {
        driver.findElement(surname).sendKeys(userSurname);
    }

    private By address  = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // поле ввода Адреса

    // ввод Адреса
    public void setAddress (String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }

    private By listOfMetro  = By.xpath(".//input[@placeholder='* Станция метро']"); // выподающтй список станций метро

    // выбор метро
    public void onClickListOfMetro(String metro) {
        driver.findElement(listOfMetro).click();
        driver.findElement(listOfMetro).sendKeys(metro);
        driver.findElement(listOfMetro).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    }

    private By chooseStation  = By.xpath(".//button[@value='3']"); // кнопка станции Преображенская площадь

    // выбор станции метро (Преображенская площадь)
    public void onClickStation() {
        driver.findElement(chooseStation).click();
    }

    private By phone  = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // поле ввода номера телефона

    // ввод номера телефона
    public void setPhone (String userPoneNumber) {
        driver.findElement(phone).sendKeys(userPoneNumber);
    }

    private By done = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //кнопка Далее

    // нажать кнопку Далее
    public void onDone() {
        driver.findElement(done).click();
    }

    public void onePageForm(String userName,String userSurname,String userAddress,String metro,String userPoneNumber) {
        setName (userName);
        setSurname (userSurname);
        setAddress (userAddress);
        onClickListOfMetro(metro);
        setPhone (userPoneNumber);
        onDone();
    }
}
