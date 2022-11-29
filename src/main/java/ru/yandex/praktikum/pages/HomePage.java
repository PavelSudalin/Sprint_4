package ru.yandex.praktikum.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    private WebDriver driver;
    String number;
    private By orderHeadButton = By.className("Button_Button__ra12g");
    private By orderBottomButton = By.className("Button_Middle__1CSJM");
    private By orderStatusButton = By.xpath(".//button[text()='Статус заказа']");
    private By enterOrderNumber = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    private By goButton = By.xpath(".//button[text() = 'Go!']");
    //Вопросы
    private By questionsAboutImportant = By.xpath(".//div[text() = 'Вопросы о важном']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage clickOrderHeadButton() {
        driver.findElement(orderHeadButton).click();
        return this;
    }

    public HomePage clickOrderBottomButton(){
        WebElement element = driver.findElement(orderBottomButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(orderBottomButton).click();
        return this;
    }
    public HomePage clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
        return this;
    }

    public HomePage inputOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(enterOrderNumber)).sendKeys(orderNumber);
        return this;
    }

    public HomePage clickGoButton() {
        driver.findElement(goButton).click();
        return this;
    }

    public String getTextHomePageQuestions(String number) {
        By homePageQuestions = By.id("accordion__heading-" + number);
        By homePageAnswer = By.id("accordion__panel-" + number);
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(homePageQuestions).click();
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(homePageAnswer).getText());
    }
}
