package org.example.scooterTest;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;

public class HomePageScooter {

    private WebDriver driver;

    public static final By questionXpath1 = By.xpath(".//div[@class='accordion__item'][1]");
    public static final By questionXpath2 = By.xpath(".//div[@class='accordion__item'][2]");
    public static final By questionXpath3 = By.xpath(".//div[@class='accordion__item'][3]");
    public static final By questionXpath4 = By.xpath(".//div[@class='accordion__item'][4]");
    public static final By questionXpath5 = By.xpath(".//div[@class='accordion__item'][5]");
    public static final By questionXpath6 = By.xpath(".//div[@class='accordion__item'][6]");
    public static final By questionXpath7 = By.xpath(".//div[@class='accordion__item'][7]");
    public static final By questionXpath8 = By.xpath(".//div[@class='accordion__item'][8]");

    public static final By answerXpath1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    public static final By answerXpath2 = By.xpath(".//div[@id='accordion__panel-1']/p");
    public static final By answerXpath3 = By.xpath(".//div[@id='accordion__panel-2']/p");
    public static final By answerXpath4 = By.xpath(".//div[@id='accordion__panel-3']/p");
    public static final By answerXpath5 = By.xpath(".//div[@id='accordion__panel-4']/p");
    public static final By answerXpath6 = By.xpath(".//div[@id='accordion__panel-5']/p");
    public static final By answerXpath7 = By.xpath(".//div[@id='accordion__panel-6']/p");
    public static final By answerXpath8 = By.xpath(".//div[@id='accordion__panel-7']/p");

    // Маленькая кнопка Заказать на чердаке
    private By headerOrderButton = By.xpath(".//button[text()='Заказать'][1]");
    // Большая кнопка Заказать на странице
    private By pageOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    public HomePageScooter(WebDriver driver){
        this.driver = driver;
    }

    // Методы для раскрытия вопросов
    public void clickQuestion(By questionXpath) {
        driver.findElement(questionXpath).click();
    }

    // Геттеры для получения текса ответов
    public String getAnswer(By answerXpath) {
        return driver.findElement(answerXpath).getText();
    }

    // Метод для сравнения ответа на вопрос с правильным текстом
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }

    // Методы для клика по кнопкам Заказать
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    public void clickPageOrderButton() {
        // Проскролить до появления кнопки
        WebElement bigButton = driver.findElement(pageOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(pageOrderButton).click();
    }
}
