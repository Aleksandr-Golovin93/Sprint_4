import PageObject.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
    @RunWith(Parameterized.class)
    public class QuestionsList {

        // ожидаемые результаты ответов
        private static final String EXPECTED_FIRST_ANSWER_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        private static final String EXPECTED_SECOND_ANSWER_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        private static final String EXPECTED_THIRD_ANSWER_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        private static final String EXPECTED_FOURTH_ANSWER_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        private static final String EXPECTED_FIFTH_ANSWER_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        private static final String EXPECTED_SIXTH_ANSWER_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        private static final String EXPECTED_SEVENTH_ANSWER_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        private static final String EXPECTED_EIGHTH_ANSWER_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        private WebDriver driver;

    private final int question;

    private final String expectedAnswer;

        public QuestionsList(int question, String expectedAnswer) {
            this.question = question;
            this.expectedAnswer = expectedAnswer;
        }

        @Parameterized.Parameters
        public static Object[][] getCredentials() {
            return new Object[][]{
                    {1, EXPECTED_FIRST_ANSWER_TEXT}, {2, EXPECTED_SECOND_ANSWER_TEXT}, {3, EXPECTED_THIRD_ANSWER_TEXT},
                    {4, EXPECTED_FOURTH_ANSWER_TEXT}, {5, EXPECTED_FIFTH_ANSWER_TEXT}, {6, EXPECTED_SIXTH_ANSWER_TEXT},
                    {7, EXPECTED_SEVENTH_ANSWER_TEXT}, {8, EXPECTED_EIGHTH_ANSWER_TEXT}
            };
        }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void QuestionText() {
        StartPage objectStartPage = new StartPage(driver);
        objectStartPage.clickCookieButton();
        String actualAnswerText = objectStartPage.getTextAnswer(question);
        assertEquals(expectedAnswer, actualAnswerText);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
