import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.pages.HomePage;
import ru.yandex.praktikum.pages.OrderFirstPage;
import ru.yandex.praktikum.pages.OrderSecondPage;
import ru.yandex.praktikum.pages.OrderStatusPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindOrder {
    private WebDriver driver;
    private String firstName = "Сергей";
    private String secondName = "Пушкин";
    private String address = "Цветной бульвар 12";
    private String phoneNumber = "84958375638";
    private String date = "29.11.2022";
    private String color = "black";
    private String comment = "Тут будет комментарий";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void viewingTheCreatedRequestForAScooter() {
        HomePage homePage = new HomePage(driver);
        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        homePage.clickOrderStatusButton()
                .inputOrderNumber("260756")
                .clickGoButton();
        orderStatusPage.waitForLoadWindow();
            assertThat(orderStatusPage.getTextOrderInfoFirstName(), containsString("Пушкин"));
        }


        @Test
        public void cancelingAScooterOrder() {
            HomePage homePage = new HomePage(driver);
            OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
            OrderFirstPage orderFirstPage = new OrderFirstPage(driver);
            OrderSecondPage orderSecondPage = new OrderSecondPage(driver);
            homePage.clickOrderButton("HeadButton");

            orderFirstPage.inputFirstName(firstName)
                    .inputSecondName(secondName)
                    .inputAddress(address)
                    .inputMetro()
                    .inputPhone(phoneNumber)
                    .clickNextButton();

            orderSecondPage.insertDate(date)
                    .insertLeaseTerm()
                    .insertColor(color)
                    .inputCommentForCourier(comment)
                    .clickOrderButton()
                    .waitForLoadModalWindow()
                    .clickOrderButtonYes();
            assertThat(orderSecondPage.getTextOrderIsProcessed(), containsString("Заказ оформлен"));

            orderSecondPage.clickLookOrderStatusButton();

            orderStatusPage.waitForLoadWindow()
                    .clickCancelButton()
                    .clickCancelButtonModal();

            assertThat(orderStatusPage.getTextOrderCancelModalText(), containsString("Заказ отменён"));
        }

    @After
    public void teardown() {
        driver.quit();
    }
}
