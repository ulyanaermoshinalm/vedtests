package ru.leroymerlin.qa.test.vedportal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class NewTest extends Driver {
    @Test
    public void test() {
        System.out.println("firstTest");
        assertThat(11).isNotZero();
    }
    @Test
    public void shouldTest2() throws InterruptedException {
        driver.get("https://leroymerlin.ru/product/stoleshnica-1200h700h28-mm-82125558/");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        driver.findElement(By.cssSelector(".border-container border-container--round border-container--large-size")).click();
        driver.findElement(By.cssSelector("#label-content inbasket-content")).wait(5000);
        //driver.findElement(By.xpath("//*[@id=\"label\"]/div[2]")).click();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);//скрол вниз
        driver.findElement(By.cssSelector(".label-content.inbasket-content")).isDisplayed();//элмент виден

        //WebElement button = driver.findElement(By.cssSelector("#label-content inbasket-content"));
        //Assert.assertEquals(true,button.isDisplayed()); //проверка видимости
        //Assert.assertEquals(false,button.isDisplayed());

    }

    @Test
    public void shouldTest3() {
        driver.get("https://leroymerlin.ru/product/stoleshnica-1200h700h28-mm-82125558/");
        WebElement input = driver.findElement(By.cssSelector(".subscription-footer-form #footer-subscribe-input"));
        //assertThat(input.isDisplayed()).isFalse();
        //ExpectedConditions::visibilityOfElementLocated("#footer-subscribe-input");
        input.sendKeys("стол");

    }

    @Test
    public void shouldTest4() throws InterruptedException {
        driver.get("https://leroymerlin.ru/product/stoleshnica-1200h700h28-mm-82125558/");
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        WebElement button = (WebElement) jse.executeScript("return document.querySelector(\"body > div.page-wrapper > div.top-page-wrapper > div.content.pinned-footer > div.line-body > div.product-content > div > div > div > div > uc-pdp-card-ga-enriched > uc-elbrus-add-to-basket-button:nth-child(3)\").shadowRoot.querySelector(\"#label\");");
        int y = button.getLocation().getY();
        scrollBy(button.getLocation().getY() - 100);
        //js.executeScript("return document.querySelector(\"body > div.page-wrapper > div.top-page-wrapper > div.content.pinned-footer > div.line-body > div.product-content > div > div > div > div > uc-pdp-card-ga-enriched > uc-elbrus-add-to-basket-button:nth-child(3)\").shadowRoot.querySelector(\"#label\").click();");
        Thread.sleep(3000);
        y = button.getLocation().getY();
        //scrollBy(button.getLocation().getY() - 256);
        //Thread.sleep(3000);
        button.click();
        Thread.sleep(3000);
    }

}
//document.querySelector("body > div.page-wrapper > div.top-page-wrapper > div.content.pinned-footer > div.line-body > div.product-content > div > div > div > div > uc-pdp-card-ga-enriched > uc-elbrus-add-to-basket-button:nth-child(4)").shadowRoot.querySelector("#label")
