package ru.leroymerlin.qa.test.vedportal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenPageTest extends Driver{


    @Test
    void shouldTest() throws InterruptedException {
        driver.get("https://leroymerlin.ru/");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);//скрол вниз
        driver.findElement(By.cssSelector("#footer-subscribe-input")).sendKeys("стол");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);//скрол вверх
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[5]/div[1]/div[1]/div/div/div/div/div[2]/div[3]/a")).click();
//        driver.findElement(By.className("section")).click();/html/body/div[4]/div[2]/div[5]/div[1]/div[3]/div/div/div/div/div[1]/div[2]/button[2]
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[5]/div[1]/div[3]/div/div/div/div/div[1]/div[2]/button[2]")).click();



    }


}
