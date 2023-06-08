package ru.yandex.praktikum.pom.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    private By orderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}