package ru.yandex.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderFirstPage {
    private WebDriver driver;

    public OrderFirstPage(WebDriver driver){
        this.driver = driver;
    }

    private By firstName = By.xpath(".//input[@placeholder = '* Имя']");
    private By secondName = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By address = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By metro = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By phone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text() = 'Далее']");

    public OrderFirstPage inputFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
        return this;
    }

    public OrderFirstPage inputSecondName(String name) {
        driver.findElement(secondName).sendKeys(name);
        return this;
    }

    public OrderFirstPage inputAddress(String addressName) {
        driver.findElement(address).sendKeys(addressName);
        return this;
    }

    //TODO Тут выпадающий список, переделать выбор
    public OrderFirstPage inputMetro() {
        driver.findElement(metro).click();
        driver.findElement(By.xpath(".//div[text() = 'Бульвар Рокоссовского']")).click();
        return this;
    }

    public OrderFirstPage inputPhone(String phoneNumber) {
        driver.findElement(phone).sendKeys(phoneNumber);
        return this;
    }

    public OrderFirstPage clickNextButton(){
        driver.findElement(nextButton).click();
        return this;
    }
}
