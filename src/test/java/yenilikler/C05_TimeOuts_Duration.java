package yenilikler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C05_TimeOuts_Duration {
    /*
    Selenium 3’de wait icin zaman tanimlarken kullandigimiz long TimeUnit kaldirilmis,
    Yerine java util kutuphanesinden Duration class’indan kullanacagimiz ofSeconds(sure) metotlari getirilmis.
    Bu degisim implicitly wait icin manage( ).timeouts( )’da oldugu gibi explicitly wait’de wait objesi olustururken de  karsimiza cikiyor.
     */
    WebDriver driver;

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        // yorumu satirinin basindaki // kaldirirsaniz Selenium 4;un TimeUnit.SECONDS kabul etmedigini gorebilirsiniz

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        // WebDriverWait wait= new WebDriverWait(driver,20);
    }

}
