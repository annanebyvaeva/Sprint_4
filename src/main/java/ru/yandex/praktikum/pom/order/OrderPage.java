package ru.yandex.praktikum.pom.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage {

    private WebDriver driver;

    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By stationField = By.className("select-search__value");
    private By stationList = By.xpath("//ul[@class = 'select-search__options']/li[position()>0]");
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");


    public OrderPage(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadOrderPage(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Content__bmtHS")));
    }

    public void setNameField(String name) {

        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
   }

    public void setSurnameField(String surname) {

        driver.findElement(surnameField).click();
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddressField(String address) {

        driver.findElement(addressField).click();
        driver.findElement(addressField).sendKeys(address);
    }

    public void setStationList(String indexStation) {

        String stations = String.format("//ul[@class = 'select-search__options']/li[position()=%s]", indexStation);
        By stat = By.xpath(stations);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(stat)).click();

    }

    public void setPhoneField(String phone) {
        driver.findElement(phoneField).click();
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void waitForLoadListStation(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(stationList));

    }

    public void clickStationField() {
        driver.findElement(stationField).click();
    }


    public void clickOrderNextButton() {
        driver.findElement(nextButton).click();
    }

    public void orderPartOne(String name, String surname, String address, String indexStation,String phone) {

        setNameField(name);
        setSurnameField(surname);
        setAddressField(address);
        clickStationField();
        waitForLoadListStation();
        setStationList(indexStation);
        setPhoneField(phone);
        clickOrderNextButton();

    }

}
