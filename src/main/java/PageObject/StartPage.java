package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
    private WebDriver driver;
    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cookieButton = By.id("rcc-confirm-button"); // кнопка куки

    // нажать кнопку куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    private By TopButtonOfOrder = By.className("Button_Button__ra12g"); // кнопка заказа в заголовке

    // нажать кнопку заказа в заголовке
    public void clickTopButtonOfOrder() {
        driver.findElement(TopButtonOfOrder).click();
    }

    //нижняя кнопка заказа
    private By BottomButtonOfOrder = By.className("Button_Middle__1CSJM");

    // нажать нижнюю кнопку заказа
    public void clickBottomButtonOfOrder() {
        driver.findElement(BottomButtonOfOrder).click();
    }

    private By firstQuestion = By.id("accordion__heading-0"); // 1 вопрос в выпадающем списке
    private By firstAnswerText = By.xpath(".//div[@id='accordion__panel-0']/p"); // 1 ответ в выпадающем списке

    // открыть первый вопрос
    public void clickFirstQuestion() {
        driver.findElement(firstQuestion).click();
    }

    // получить текст ответа на первый вопрос
    public String getFirstAnswerText() {
        return driver.findElement(firstAnswerText).getText();
    }

    private By secondQuestion = By.id("accordion__heading-1"); // 2 вопрос в выпадающем списке
    private By secondAnswerText = By.xpath(".//div[@id='accordion__panel-1']/p"); // 2 ответ в выпадающем списке

    // открыть второй вопрос
    public void clickSecondQuestion() {
        driver.findElement(secondQuestion).click();
    }

    // получить текст ответа на второй вопрос
    public String getSecondAnswerText() {
        return driver.findElement(secondAnswerText).getText();
    }

    private By thirdQuestion = By.id("accordion__heading-2");  //3 вопрос в выпадающем списке
    private By thirdAnswerText = By.xpath(".//div[@id='accordion__panel-2']/p"); // 3 ответ в выпадающем списке

    // открыть третий вопрос
    public void clickThirdQuestion() {
        driver.findElement(thirdQuestion).click();
    }

    // получить текст ответа на третий вопрос
    public String getThirdAnswerText() {
        return driver.findElement(thirdAnswerText).getText();
    }

    private By fourthQuestion = By.id("accordion__heading-3");   //4 вопрос в выпадающем списке
    private By fourthAnswerText = By.xpath(".//div[@id='accordion__panel-3']/p"); //4 ответ в выпадающем списке

    // открыть четвёртый вопрос
    public void clickFourthQuestion() {
        driver.findElement(fourthQuestion).click();
    }

    // получить текст ответа на четвёртый вопрос
    public String getFourthAnswerText() {
        return driver.findElement(fourthAnswerText).getText();
    }

    private By fifthQuestion = By.id("accordion__heading-4"); //5 вопрос в выпадающем списке
    private By fifthAnswerText = By.xpath(".//div[@id='accordion__panel-4']/p"); //5 ответ в выпадающем списке

    // открыть пятый вопрос
    public void clickFifthQuestion() {
        driver.findElement(fifthQuestion).click();
    }

    // получить текст ответа на пятый вопрос
    public String getFifthAnswerText() {
        return driver.findElement(fifthAnswerText).getText();
    }

    private By sixthQuestion = By.id("accordion__heading-5"); //6 вопрос в выпадающем списке
    private By sixthAnswerText = By.xpath(".//div[@id='accordion__panel-5']/p"); //6 ответ в выпадающем списке

    // открыть шестой вопрос
    public void clickSixthQuestion() {
        driver.findElement(sixthQuestion).click();
    }

    // получить текст ответа на шестой вопрос
    public String getSixthAnswerText() {
        return driver.findElement(sixthAnswerText).getText();
    }

    private By seventhQuestion = By.id("accordion__heading-6");  //7 вопрос в выпадающем списке
    private By seventhAnswerText = By.xpath(".//div[@id='accordion__panel-6']/p"); //7 ответ в выпадающем списке

    // открыть седьмой вопрос
    public void clickSeventhQuestion() {
        driver.findElement(seventhQuestion).click();
    }

    // получить текст ответа на седьмой вопрос
    public String getSeventhAnswerText() {
        return driver.findElement(seventhAnswerText).getText();
    }

    private By eighthQuestion = By.id("accordion__heading-7"); //8 вопрос в выпадающем списке
    private By eighthAnswerText = By.xpath(".//div[@id='accordion__panel-7']/p"); //8 ответ в выпадающем списке

    // открыть восьмой вопрос
    public void clickEighthQuestion() {
        driver.findElement(eighthQuestion).click();
    }

    // получить текст ответа на восьмой вопрос
    public String getEighthAnswerText() {
        return driver.findElement(eighthAnswerText).getText();
    }
}
