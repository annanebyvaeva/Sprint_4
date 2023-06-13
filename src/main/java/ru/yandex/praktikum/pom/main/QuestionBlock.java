package ru.yandex.praktikum.pom.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class QuestionBlock {

    private WebDriver driver;

    public QuestionBlock(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
    }

    public void scrollQuestion() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(".accordion")));

    }

}

