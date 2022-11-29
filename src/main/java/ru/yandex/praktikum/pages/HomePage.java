package ru.yandex.praktikum.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    private WebDriver driver;
    private By orderHeadButton = By.className("Button_Button__ra12g");
    private By orderBottomButton = By.className("Button_Middle__1CSJM");
    private By orderStatusButton = By.xpath(".//button[text()='Статус заказа']");
    private By enterOrderNumber = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    private By goButton = By.xpath(".//button[text() = 'Go!']");
    //Вопросы
    private By questionsAboutImportant = By.xpath(".//div[text() = 'Вопросы о важном']");
    //Сколько это стоит? И как оплатить?
    private By howMuchIsCostQuestion = By.xpath(".//*[@id='accordion__heading-0']");
    private By howMuchIsCostAnswer = By.xpath(".//*[@id = 'accordion__panel-0']");
    //Хочу сразу несколько самокатов! Так можно?
    private By severalScootersAtOnceQuestion = By.xpath(".//*[@id='accordion__heading-1']");
    private By severalScootersAtOnceAnswer = By.xpath(".//*[@id='accordion__panel-1']");

    //Как рассчитывается время аренды?
    private By rentalTimeCalculationQuestion = By.xpath(".//*[@id='accordion__heading-2']");
    private By rentalTimeCalculationAnswer = By.xpath(".//*[@id='accordion__panel-2']");

    //Можно ли заказать самокат прямо на сегодня?
    private By orderScooterRightForTodayQuestion = By.xpath(".//*[@id='accordion__heading-3']");
    private By orderScooterRightForTodayAnswer = By.xpath(".//*[@id='accordion__panel-3']");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private By extendOrderOrReturnScooterQuestion = By.xpath(".//*[@id='accordion__heading-4']");
    private By extendOrderOrReturnScooterAnswer = By.xpath(".//*[@id='accordion__panel-4']");
    //Вы привозите зарядку вместе с самокатом?
    private By scooterChargingQuestion = By.xpath(".//*[@id='accordion__heading-5']");
    private By scooterChargingAnswer = By.xpath(".//*[@id='accordion__panel-5']");
    //Можно ли отменить заказ?
    private By scooterCancellationQuestion = By.xpath(".//*[@id='accordion__heading-6']");
    private By scooterCancellationAnswer = By.xpath(".//*[@id='accordion__panel-6']");

    //Я живу за МКАДом, привезёте?
    //TODO опечатка в вопросе, жизу, добавить проверку
    private By scooterDeliveryQuestion = By.xpath(".//*[@id='accordion__heading-7']");
    private By scooterDeliveryAnswer = By.xpath(".//*[@id='accordion__panel-7']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage clickOrderHeadButton() {
        driver.findElement(orderHeadButton).click();
        return this;
    }

    public HomePage clickOrderBottomButton() {
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

    public String getTextHowMuchIsCostQuestion() {
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(howMuchIsCostQuestion).click();
        String actual = driver.findElement(howMuchIsCostAnswer).getText();
        return actual;
    }

    public String getTextSeveralScootersAtOnceQuestion() {
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(severalScootersAtOnceQuestion).click();
        String actual = driver.findElement(severalScootersAtOnceAnswer).getText();
        return actual;
    }
    public String getTextRentalTimeCalculationQuestion() {
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(rentalTimeCalculationQuestion).click();
        String actual = driver.findElement(rentalTimeCalculationAnswer).getText();
        return actual;
    }
    public String getTextOrderScooterRightForTodayQuestion() {
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(orderScooterRightForTodayQuestion).click();
        String actual = driver.findElement(orderScooterRightForTodayAnswer).getText();
        return actual;
    }
    public String getTextExtendOrderOrReturnScooterQuestion() {
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(extendOrderOrReturnScooterQuestion).click();
        String actual = driver.findElement(extendOrderOrReturnScooterAnswer).getText();
        return actual;
    }
    public String getTextScooterChargingQuestion() {
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(scooterChargingQuestion).click();
        String actual = driver.findElement(scooterChargingAnswer).getText();
        return actual;
    }
    public String getTextScooterCancellationQuestion() {
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(scooterCancellationQuestion).click();
        String actual = driver.findElement(scooterCancellationAnswer).getText();
        return actual;
    }
    public String getTextScooterDeliveryQuestion() {
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(scooterDeliveryQuestion).click();
        String actual = driver.findElement(scooterDeliveryAnswer).getText();
        return actual;
    }


}
