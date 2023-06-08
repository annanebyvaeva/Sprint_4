package ru.yandex.praktikum.pom.submit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SubmitForm {

    private WebDriver driver;

    public SubmitForm(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
    }

    private By submitButton = By.xpath("//button[text() = 'Да']");


    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

}
