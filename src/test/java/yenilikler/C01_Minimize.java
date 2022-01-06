package yenilikler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
    /*
        Selenium 3’de var olan window manage ozelliklerine ek olarak minimize() eklendi.
        minimize( ) ile normal hayatta yaptiginiz sekilde window’u sembol olarak asagi indirebilirsiniz.

        1- Asagidaki ornekte amazon anasayfaya gidip 3 saniye gormek icin bekleyip, browser'i minimize yapacagiz
        2- 5 saniye minimize olarak bekleyip sonra tekrar calismak icin browser'i maximize yapacagiz
        3- gormek icin 5 saniye bekleyip kapatacagiz
     */
public class C01_Minimize {

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("https://www.amazon.com"); // amazona git

        Thread.sleep(3000);

        driver.manage().window().minimize(); // minimize yap

        Thread.sleep(5000);

        driver.manage().window().maximize(); // maximize yap

        Thread.sleep(5000);

        driver.close(); // kapat
    }
}
