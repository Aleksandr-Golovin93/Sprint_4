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
    private int numberButton;
    private String name;
    private String surname;
    private String address;
    private String metro;
    private String phone;
    private String yearMonth;
    private int day;

    private String comment;
    private StartPage objectStartPage;
    private UserFormOrder objectUserOrderForm;
    private RentFormPage objectRentForm;
    private AcceptModalPage objectAcceptModal;

    public ScooterOrder(int numberButton,
                     String name, String surname, String address, String metro, String phone,
                     String yearMonth, int day) {
        this.numberButton = numberButton;

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;

        this.yearMonth = yearMonth;
        this.day = day;
    }

    public void onePageOrder(int numberButton,
                             String name,String surname,String address, String metro, String phone) {
        objectStartPage.clickCookieButton();
        objectStartPage.clickButtonOfOrder(numberButton);
        objectUserOrderForm.setName(name);
        objectUserOrderForm.setSurname(surname);
        objectUserOrderForm.setAddress(address);
        objectUserOrderForm.onClickListOfMetro();
        objectUserOrderForm.onClickStation();
        objectUserOrderForm.setPhone(phone);
        objectUserOrderForm.onDone();
    }


    private String expectedTextSuccessfulOrder = "Заказ оформлен";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage objectStartPage = new StartPage(driver);
        UserFormOrder objectUserOrderForm = new UserFormOrder(driver);
        RentFormPage objectRentForm = new RentFormPage(driver);
        AcceptModalPage objectAcceptModal = new AcceptModalPage(driver);
    }

    @Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {1,
                        "Александр", "Головин", "Королёва 2", "Преображенская площадь", "+79379808499",
                        "2022-12", 5},
                {2,
                        "Губка", "Боб", "Дыбенко 3", "Преображенская площадь", "+79370900990",
                        "2022-12", 5}
        };
    }

    @Test
    public void firstOrder() {
        /* Для работы с Mozilla Firefox */
//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);

        /* Для работы с Google Chrome */
        driver = new ChromeDriver();
        onePageOrder(numberButton,name,surname,address, metro,phone);
        objectRentForm.onClickDate();
        objectRentForm.onClickCalendar();
        objectRentForm.onClickListPeriod();
        objectRentForm.onClickPeriod();
        objectRentForm.onDone();
        objectRentForm.onDoneModal();
        String actualTextSuccessfulOrder = objectAcceptModal.getTitleAcceptModel();
        MatcherAssert.assertThat(actualTextSuccessfulOrder, startsWith(expectedTextSuccessfulOrder));
    }

    @Test
    public void secondOrder() {
        /* Для работы с Mozilla Firefox */
//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);

        /* Для работы с Google Chrome */

        objectStartPage.clickBottomButtonOfOrder();
        onePageOrder(numberButton,name,surname,address, metro,phone);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button")));
        WebElement element = driver.findElement(By.cssSelector("#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        objectRentForm.onClickDate();
        objectRentForm.onClickCalendar();
        objectRentForm.onClickListPeriod();
        objectRentForm.onClickPeriod();
        objectRentForm.onDone();
        objectRentForm.onDoneModal();
        String actualTextSuccessfulOrder = objectAcceptModal.getTitleAcceptModel();
        MatcherAssert.assertThat(actualTextSuccessfulOrder, startsWith(expectedTextSuccessfulOrder));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
