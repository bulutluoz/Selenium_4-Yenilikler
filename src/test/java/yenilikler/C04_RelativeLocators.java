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
    /*
    Selenium 3’de Web Element’leri locate etmek icin kullandigimiz 8 adet locator Selenium 4’de de var
    Var olan bu method’larin yanina Selenium 4 Devrim gibi bir ozellik eklemis
    Eklenen RelativeLocator Class’indaki method’lar sayesinde bir web elementi etrafindaki diger web elementler ile tanimlayabilirsiniz

    Bazi web elementlerde developer’lar dinamik ozellikler kullandiklarindan sabit bir locator bulamayabilirsiniz.
    Ornegin mountie web elementinin id'si dinamik yani her calistiginda farkli bir deger aliyor
    Bu durumda Selenium 4 imdadiniza yetisip, gunluk hayatimizda kullandigimiz adres tariflerine benzer bir imkan sunuyor.
    Once with ile var olan her hangi bir ozelligini soyleyip sonra etrafindaki web elementleriyle tarif verebilirsiniz
    Asagidaki ornekte boston ve sailor web elementlerini locate edip, onlar uzerinden berlin ve mountie web elementlerini locate ettim.

     */
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
