import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pages.HomePage;
import ru.yandex.praktikum.pages.OrderFirstPage;
import ru.yandex.praktikum.pages.OrderSecondPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private WebDriver driver;
    private String firstName;
    private String secondName;
    private String address;
    private String phoneNumber;
    private String date;
    private String color;
    private String comment;
    private String button;
    private String orderModalWindow = "Заказ оформлен";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    public OrderScooterTest(String button, String firstName, String secondName, String address, String phoneNumber,
                            String date, String color, String comment) {
        this.button = button;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "{index}: {0}, {1}, {2}")
    public static Object[][] getUserData() {
        return new Object[][]{
                {"headButton", "Александр", "Пушкин", "Цветной бульвар 16", "84953574758", "25.11.2022", "black", "Как можно быстрее"},
                {"bottomButton", "Пупков", "Вечеслав", "Буденного проезд 2", "79995748392", "27.12.2022", "grey", "Могу подождать"}
        };
    }

    @Test
    public void successfulScooterOrderButton() {
        HomePage homePage = new HomePage(driver);
        OrderFirstPage orderFirstPage = new OrderFirstPage(driver);
        OrderSecondPage orderSecondPage = new OrderSecondPage(driver);
        homePage.clickOrderButton(button);
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

        assertThat(orderSecondPage.getTextOrderIsProcessed(), containsString(orderModalWindow));
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
