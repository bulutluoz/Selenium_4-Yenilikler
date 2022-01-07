package yenilikler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C03_WebElementGet {
    WebDriver driver;
    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        System.out.println("==========Selenium 3 de olanlar===========");
        System.out.println("yukseklik : " + aramaKutusu.getRect().getHeight());
        System.out.println("dimension : " + aramaKutusu.getRect().getDimension());
        System.out.println("X koordinat : " + aramaKutusu.getRect().getX());
        System.out.println("Y koordinat : " + aramaKutusu.getRect().getY());
        System.out.println("point : " + aramaKutusu.getRect().getPoint());
        System.out.println("height : " + aramaKutusu.getRect().height);
        System.out.println("width : " + aramaKutusu.getRect().width);
        System.out.println("Location : " + aramaKutusu.getLocation());
        System.out.println("Size : " + aramaKutusu.getSize());
        System.out.println("Tag name : " + aramaKutusu.getTagName());
        System.out.println("width : " + aramaKutusu.getAttribute("id"));

        /*
        "==========Selenium 4 de kaldirilan ozellikler==========="
        aramaKutusu.getRect().setWidth(100);
        aramaKutusu.getRect().setHeight(40);
        aramaKutusu.getRect().setX(200);
        aramaKutusu.getRect().setY(200);
        */

        System.out.println("==========Selenium 4 de gelen yenilikler===========");
        System.out.println("dom property : " + aramaKutusu.getDomProperty("id"));
        System.out.println("accesible name: " + aramaKutusu.getAccessibleName());
        System.out.println("Aria role : " + aramaKutusu.getAriaRole());




    }
}
