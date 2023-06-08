package order;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pom.main.HeaderPage;
import ru.yandex.praktikum.pom.main.MainPage;
import ru.yandex.praktikum.pom.order.OrderPage;
import ru.yandex.praktikum.pom.order.OrderRentPage;
import ru.yandex.praktikum.pom.submit.SubmitForm;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest {

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Анна", "Первая", "Москва", "3", "89180000001","15.08.2023", "сутки", "grey", "Позвоните", true},
                { "Ольга", "Вторая", "Санкт-Петербург", "4", "89180000002", "16.10.2023", "четверо суток", "black", "Не звоните", true},
        };
    }

    private WebDriver driver ;

    public String name;
    public String surname;
    public String address;
    public String indexStation;
    public String phone;
    public String data;
    public String valueDay;
    public String colorCheckbox;
    public String comment;
    public boolean result;

    public OrderTest(String name, String surname, String address, String indexStation, String phone, String data, String valueDay, String colorCheckbox, String comment, boolean result) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.indexStation = indexStation;
        this.phone = phone;
        this.data = data;
        this.valueDay = valueDay;
        this.colorCheckbox = colorCheckbox;
        this.comment = comment;
        this.result = result;

    }

    @Test

    public void checkOrderHeaderTrue() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.waitForLoadOrderPage();
        orderPage.orderPartOne(name, surname, address, indexStation, phone);
        OrderRentPage orderRentPage = new OrderRentPage(driver);
        orderRentPage.waitForLoadOrderRentPage();
        orderRentPage.orderPartTwo(data, valueDay, colorCheckbox, comment);
        SubmitForm submitForm = new SubmitForm(driver);
        submitForm.clickSubmitButton();
        assertEquals(result, driver.findElement(By.xpath("//div[contains(text(), 'Заказ оформлен')]")).isDisplayed());

    }

    @Test

    public void checkOrderMainTrue() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonMain();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.waitForLoadOrderPage();
        orderPage.orderPartOne(name, surname, address, indexStation, phone);
        OrderRentPage orderRentPage = new OrderRentPage(driver);
        orderRentPage.waitForLoadOrderRentPage();
        orderRentPage.orderPartTwo(data, valueDay, colorCheckbox, comment);
        SubmitForm submitForm = new SubmitForm(driver);
        submitForm.clickSubmitButton();
        assertEquals(result, driver.findElement(By.xpath("//div[contains(text(), 'Заказ оформлен')]")).isDisplayed());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}




