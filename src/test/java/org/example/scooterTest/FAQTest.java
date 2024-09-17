package org.example.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.scooterTest.HomePageScooter.*;
import static org.example.scooterTest.Resources.*;

@RunWith(Parameterized.class)
public class FAQTest {

    private WebDriver driver;
    private final String answerText;
    private final By answerXpath;
    private final By questionXpath;

    public FAQTest(String answerText, By answerXpath, By questionXpath) {
        this.answerText = answerText;
        this.answerXpath = answerXpath;
        this.questionXpath = questionXpath;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswerText() {
        return new Object[][] {
                {answer1Text, answerXpath1, questionXpath1},
                {answer2Text, answerXpath2, questionXpath2},
                {answer3Text, answerXpath3, questionXpath3},
                {answer4Text, answerXpath4, questionXpath4},
                {answer5Text, answerXpath5, questionXpath5},
                {answer6Text, answerXpath6, questionXpath6},
                {answer7Text, answerXpath7, questionXpath7},
                {answer8Text, answerXpath8, questionXpath8},
        };
    }

    @Test
    public void FAQCorrectAnswerText() {
        // Создать веб-драйвер для Google Chrome
        driver = new ChromeDriver();
        // Открыть страницу домашнюю Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");
        // Проскролить страницу до появления таблицы с вопросами
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
        // Создать объект класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);
        // Проверка соответствия текста ответа с ожидаемым
        objHomePage.clickQuestion(questionXpath);
        objHomePage.isCorrectText(objHomePage.getAnswer(answerXpath), answerText);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
