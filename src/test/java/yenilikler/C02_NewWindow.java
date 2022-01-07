package yenilikler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

    /*
    Selenium 3’de var olan switchTo ( ) ozelliklerine ek olarak newWindow() eklendi.
    Yeni pencereyi isterseniz TAB, isterseniz yeni WINDOW olarak acabilirsiniz.

    Asagidaki ornekte
        1- amazon anasayfaya gidip 3 saniye gormek icin bekleyecegiz,
        2- tekrar bu sayfaya donebimek icin ilk sayfanin window handle degerini alip bir String degiskene atayacagiz
        3- Yeni bir sayfayi tab olarak acip facebook anasayfaya gidecegiz ve 3 saniye bekleyecegiz
        4- aldigimiz window handle degerini kullanarak amazon sayfasinin acik oldugu window'a donecegiz
        5- Yeni sayfayi ayri bir wondow olarak acip instagram anasayfaya gidecegiz ve 3 saniye bekleyecegiz
        6- Yine amazon sayfasinin acik oldugu window'a donecegiz ve tum sayfalari quit ile kapatacagiz
    */

public class C02_NewWindow {
    WebDriver driver;
    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com");

        Thread.sleep(3000);

        driver.switchTo().window(ilkSayfaHandleDegeri);
        Thread.sleep(3000);


        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.instagram.com");
        Thread.sleep(3000);

        driver.switchTo().window(ilkSayfaHandleDegeri);
        Thread.sleep(3000);

        driver.quit();

    }
}
