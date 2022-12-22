import PageObject.AcceptModalPage;
import PageObject.RentFormPage;
import PageObject.StartPage;
import PageObject.UserFormOrder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runners.Parameterized.Parameters;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class ScooterOrder {

    private WebDriver driver;
    private final int numberButton;
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String metro;
    private final String userPoneNumber;
    private final String newDate;
    private final int day;

    public ScooterOrder(int numberButton,
                     String userName, String userSurname, String userAddress, String metro, String userPoneNumber,
                     String newDate, int day) {
        this.numberButton = numberButton;

        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.metro = metro;
        this.userPoneNumber = userPoneNumber;

        this.newDate = newDate;
        this.day = day;
    }

    private String expectedTextSuccessfulOrder = "Заказ оформлен";

    @Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {1,
                        "Александр", "Головин", "Королёва 2", "Преображенская площадь", "+79379808499",
                        "13.12.2022", 5},
                {2,
                        "Губка", "Боб", "Дыбенко 3", "Преображенская площадь", "+79370900990",
                        "17.12.2022", 3}
        };
    }

    @Test
    public void firstOrder() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage objectStartPage = new StartPage(driver);
        objectStartPage.clickCookieButton(); // подтвердил куки
        objectStartPage.clickButtonOfOrder(numberButton); // выбрал кнопку

        UserFormOrder objectUserOrderForm = new UserFormOrder(driver);
        //заполнение полей
        objectUserOrderForm.onePageForm(userName,userSurname,userAddress, metro,userPoneNumber);

        RentFormPage objectRentForm = new RentFormPage(driver);
        //заполнение полей
        objectRentForm.secondPageForm(newDate,day);

        AcceptModalPage objectAcceptModal = new AcceptModalPage(driver);
        String actualTextSuccessfulOrder = objectAcceptModal.getTitleAcceptModel();
        MatcherAssert.assertThat(actualTextSuccessfulOrder, startsWith(expectedTextSuccessfulOrder));
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
