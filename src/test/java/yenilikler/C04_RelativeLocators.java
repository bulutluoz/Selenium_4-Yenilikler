package yenilikler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_RelativeLocators {
    WebDriver driver;

    @Test
    public void test(){

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();


    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement boston = driver.findElement(By.id("boston"));
        WebElement sailor = driver.findElement(By.id("sailor"));

        WebElement berlin= driver.findElement(RelativeLocator.with(By.tagName("li")).above(sailor).toRightOf(boston));
        WebElement mountie= driver.findElement(RelativeLocator.with(By.className("ui-li-aside")).below(boston));

        Assert.assertEquals(berlin.getAttribute("id"),"berlin");
        Assert.assertEquals(mountie.getText(),"Mountie");
}
}
