package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderStatusPage {
    private WebDriver driver;

    public OrderStatusPage(WebDriver driver){
        this.driver = driver;
    }
    private By viewButton = By.xpath(".//button[text() = 'Посмотреть']");

    private By orderInfo = By.xpath(".//div[1]/div[2][@class = 'Track_Value__15eEX']");
    private By cancelButton = By.xpath(".//button[text() = 'Отменить заказ']");
    private By cancelButtonModal = By.xpath(".//button[text() = 'Отменить']");
    private By orderCancelModalText = By.className("Order_ModalHeader__3FDaJ");
    private By okButtonModalWindow = By.xpath(".//button[text() = 'Хорошо']");

    public String getTextOrderInfoFirstName() {
        String actual = driver.findElement(orderInfo).getText();
        return actual;
    }
    public OrderStatusPage waitForLoadWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> (driver.findElement(viewButton)
                        .getText() != null
                        && !driver.findElement(viewButton).getText().isEmpty()
                ));
        return this;
    }

    public OrderStatusPage clickCancelButton() {
        driver.findElement(cancelButton).click();
        return this;
    }

    public OrderStatusPage clickCancelButtonModal() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(cancelButtonModal)).click();
        return this;
    }

    public String getTextOrderCancelModalText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(okButtonModalWindow));
        String actual = driver.findElement(orderCancelModalText).getText();
        return actual;
    }

}
