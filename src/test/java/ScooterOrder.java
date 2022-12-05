import PageObject.AcceptModalPage;
import PageObject.RentFormPage;
import PageObject.StartPage;
import PageObject.UserFormOrder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.startsWith;

public class ScooterOrder {

    private WebDriver driver;
    private String expectedTextSuccessfulOrder = "Заказ оформлен";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstOrder() {
        /* Для работы с Mozilla Firefox */
//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);

        /* Для работы с Google Chrome */
        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        StartPage objectStartPage = new StartPage(driver);
        UserFormOrder objectUserOrderForm = new UserFormOrder(driver);
        RentFormPage objectRentForm = new RentFormPage(driver);
        AcceptModalPage objectAcceptModal = new AcceptModalPage(driver);

        objectStartPage.clickCookieButton();
        objectStartPage.clickTopButtonOfOrder();
        objectUserOrderForm.setName("Александр");
        objectUserOrderForm.setSurname("Головин");
        objectUserOrderForm.setAddress("Королёва 2");
        objectUserOrderForm.setPhone("+79379808499");
        objectUserOrderForm.onClickListOfMetro();
        objectUserOrderForm.onClickStation();
        objectUserOrderForm.onDone();
        objectRentForm.onClickDate();
        objectRentForm.onClickCalendar();
        objectRentForm.onClickListPeriod();
        objectRentForm.onClickPeriod();
        objectRentForm.onDone();
        objectRentForm.onDoneModal();
        String actualTextSuccessfulOrder = objectAcceptModal.getTitleAcceptModel();
        MatcherAssert.assertThat(actualTextSuccessfulOrder, startsWith(expectedTextSuccessfulOrder));
        System.out.println(actualTextSuccessfulOrder);
    }

    @Test
    public void secondOrder() {
        /* Для работы с Mozilla Firefox */
//        FirefoxOptions options = new FirefoxOptions();
//        driver = new FirefoxDriver(options);

        /* Для работы с Google Chrome */
        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        StartPage objectStartPage = new StartPage(driver);
        UserFormOrder objectUserOrderForm = new UserFormOrder(driver);
        RentFormPage objectRentForm = new RentFormPage(driver);
        AcceptModalPage objectAcceptModal = new AcceptModalPage(driver);

        objectStartPage.clickCookieButton();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button")));
        WebElement element = driver.findElement(By.cssSelector("#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        objectStartPage.clickBottomButtonOfOrder();
        objectUserOrderForm.setName("Губка");
        objectUserOrderForm.setSurname("Боб");
        objectUserOrderForm.setAddress("Дыбенко 3");
        objectUserOrderForm.setPhone("+70990900990");
        objectUserOrderForm.onClickListOfMetro();
        objectUserOrderForm.onClickStation();
        objectUserOrderForm.onDone();
        objectRentForm.onClickDate();
        objectRentForm.onClickCalendar();
        objectRentForm.onClickListPeriod();
        objectRentForm.onClickPeriod();
        objectRentForm.onDone();
        objectRentForm.onDoneModal();
        String actualTextSuccessfulOrder = objectAcceptModal.getTitleAcceptModel();
        MatcherAssert.assertThat(actualTextSuccessfulOrder, startsWith(expectedTextSuccessfulOrder));
        System.out.println(actualTextSuccessfulOrder);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
