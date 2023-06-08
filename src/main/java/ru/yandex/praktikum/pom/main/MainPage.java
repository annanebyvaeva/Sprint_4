package ru.yandex.praktikum.pom.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private By orderButtonMain = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonMain() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonMain));
        driver.findElement(orderButtonMain).click();
    }

}