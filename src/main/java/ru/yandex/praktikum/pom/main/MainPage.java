package ru.yandex.praktikum.pom.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    private By orderButtonMain = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    private String orderHeader = "Header";
    private String orderMain = "Main";

    public MainPage(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
    }

    String[] buttons = {orderHeader, orderMain};


    public void clickOrderButton(String orderButtonValue) {

        if (buttons[0] == orderButtonValue) {
            driver.findElement(orderButtonHeader).click();
        } else {
            if (buttons[1] == orderButtonValue) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonMain));
                driver.findElement(orderButtonMain).click();

            }

        }


    }

}