package ru.yandex.praktikum.pom.order;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderRentPage {

    private WebDriver driver;

    private By dataField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.className("Dropdown-control");
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private By orderButton = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM'] [contains(text(), 'Заказать')]");

    public OrderRentPage(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadOrderRentPage(){
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Form__17u6u")));
    }


    public void clickRentalPeriodField(){
        driver.findElement(rentalPeriodField).click();
    }

    public void clickCommentField(){
        driver.findElement(commentField).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }


    public void setDataField(String data) {

        driver.findElement(dataField).click();
        driver.findElement(dataField).sendKeys(data);
        driver.findElement(dataField).sendKeys(Keys.ENTER);
    }

    public void setRentalPeriodField(String valueDay){

            String rent = String.format("//div [contains(text(), '%s')]", valueDay);
            By day = By.xpath(rent);
            new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(day)).click();

        }

    public void setColorCheckbox(String colorCheckbox){

        String colorFormat = String.format(".//input [@id = '%s']", colorCheckbox);
        By color = By.xpath(colorFormat);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(color)).click();

    }

    public void setCommentField(String comment) {

        driver.findElement(commentField).sendKeys(comment);
    }



    public void orderPartTwo(String data,String valueDay, String colorCheckbox, String comment) {

        setDataField(data);
        clickRentalPeriodField();
        setRentalPeriodField(valueDay);
        setColorCheckbox(colorCheckbox);
        clickCommentField();
        setCommentField(comment);
        clickOrderButton();

    }


}


