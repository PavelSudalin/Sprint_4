package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderSecondPage {
    private WebDriver driver;

    public OrderSecondPage(WebDriver driver){
        this.driver = driver;
    }

    private By date = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By leaseTerm = By.className("Dropdown-arrow");
    private By leaseTermOneDay = By.xpath(".//div[text() = 'сутки']");
    private By colorBlack = By.id("black");
    private By colorGrey = By.id("grey");
    private By commentForCourier = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By backButton = By.xpath(".//button[text() = 'Назад']");
    private By orderButton = By.xpath(".//button[2][text() = 'Заказать']");
    private By modalOrderButtonYes = By.xpath(".//button[text() = 'Да']");
    private By modalWindow = By.xpath(".//div[text() = 'Хотите оформить заказ?']");
    private By orderIsProcessed = By.className("Order_ModalHeader__3FDaJ");
    private By lookOrderStatusButton = By.xpath(".//button[text() = 'Посмотреть статус']");


    public OrderSecondPage insertDate(String ddmmyyyy) {
        driver.findElement(date).sendKeys(ddmmyyyy);
        return this;
    }

    public OrderSecondPage insertLeaseTerm() {
        driver.findElement(leaseTerm).click();
        driver.findElement(leaseTermOneDay).click();
        return this;
    }

    public OrderSecondPage insertColor(String color) {
        if ("black".equals(color)) {
            driver.findElement(colorBlack).click();
        } else {
            driver.findElement(colorGrey).click();
        }
        return this;
    }

    public OrderSecondPage inputCommentForCourier(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
        return this;
    }

    public OrderSecondPage clickBackButton() {
        driver.findElement(backButton).click();
        return this;
    }

    public OrderSecondPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    public OrderSecondPage clickOrderButtonYes(){
        driver.findElement(modalOrderButtonYes).click();
        return this;
    }

    public String getTextOrderIsProcessed() {
        String actual;
        actual = driver.findElement(orderIsProcessed).getText();
        return actual;
    }

    public OrderSecondPage waitForLoadModalWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> (driver.findElement(modalWindow)
                        .getText() != null
                && !driver.findElement(modalWindow).getText().isEmpty()
        ));
        return this;
    }

    public OrderSecondPage clickLookOrderStatusButton() {
        driver.findElement(lookOrderStatusButton).click();
        return this;
    }
}
