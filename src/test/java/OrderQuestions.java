import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pages.HomePage;
import static org.junit.Assert.assertEquals;

public class OrderQuestions {
    private WebDriver driver;
    private String expectedAnswersHowMuchIsCostQuestion = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private String expectedSeveralScootersAtOnceQuestion = "Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private String expectedRentalTimeCalculationQuestion = "Допустим, вы оформляете заказ на 8 мая. " +
            "Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
            " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private String expectedOrderScooterRightForTodayQuestion = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private String expectedExtendOrderOrReturnScooterQuestion = "Пока что нет! Но если что-то срочное — всегда можно позвонить " +
            "в поддержку по красивому номеру 1010.";
    private String expectedScooterChargingQuestion = "Самокат приезжает к вам с полной зарядкой. " +
            "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private String expectedScooterCancellationQuestion = "Да, пока самокат не привезли. Штрафа не будет, " +
            "объяснительной записки тоже не попросим. Все же свои.";
    private String expectedScooterDeliveryQuestion = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void checkingAnswersHowMuchIsCostQuestion() {
        HomePage actual = new HomePage(driver);
        assertEquals(expectedAnswersHowMuchIsCostQuestion, actual.getTextHowMuchIsCostQuestion());
    }

    @Test
    public void checkingSeveralScootersAtOnceQuestion() {
        HomePage actual = new HomePage(driver);
        assertEquals(expectedSeveralScootersAtOnceQuestion, actual.getTextSeveralScootersAtOnceQuestion());
    }

    @Test
    public void checkingRentalTimeCalculationQuestion() {
        HomePage actual = new HomePage(driver);
        assertEquals(expectedRentalTimeCalculationQuestion, actual.getTextRentalTimeCalculationQuestion());
    }

    @Test
    public void checkingOrderScooterRightForTodayQuestion() {
        HomePage actual = new HomePage(driver);
        assertEquals(expectedOrderScooterRightForTodayQuestion, actual.getTextOrderScooterRightForTodayQuestion());
    }

    @Test
    public void checkingExtendOrderOrReturnScooterQuestion() {
        HomePage actual = new HomePage(driver);
        assertEquals(expectedExtendOrderOrReturnScooterQuestion, actual.getTextExtendOrderOrReturnScooterQuestion());
    }

    @Test
    public void checkingScooterChargingQuestion() {
        HomePage actual = new HomePage(driver);
        assertEquals(expectedScooterChargingQuestion, actual.getTextScooterChargingQuestion());
    }

    @Test
    public void checkingScooterCancellationQuestion() {
        HomePage actual = new HomePage(driver);
        assertEquals(expectedScooterCancellationQuestion, actual.getTextScooterCancellationQuestion());
    }

    @Test
    public void checkingScooterDeliveryQuestion() {
        HomePage actual = new HomePage(driver);
        assertEquals(expectedScooterDeliveryQuestion, actual.getTextScooterDeliveryQuestion());
    }


    @After
    public void teardown() {
        driver.quit();
    }

}
