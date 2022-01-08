package yenilikler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class C06_WebDriverManager {
    /*
    Selenium 3’de desteklenen browser’lardan phantomjs Selenium 4’de kaldirilirken,
    Selenium 3’de direk kullanilmayip getInstance ( ) ile kullanilabilen safaridriver selenium 4’de direk kullanima acilmis

    NOT : Bazi kaynaklarda Selenium 4’de Opera desteginin de kaldirildigi yazsa da
    asagida gorebileceginiz sekilde operadriver listede yerini aliyor

     */
    WebDriver driver;

    @Test
    public void test() {

        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();

        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();


    }
}
