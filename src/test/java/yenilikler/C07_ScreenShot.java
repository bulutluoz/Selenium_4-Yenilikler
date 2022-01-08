package yenilikler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

        /*
        Selenium 3 de ekran fotografi almak mumkundu ancak bir method olusturmak ve onu kullanmak gerekiyordu
        Selenium 4'de tum ekranin fotografini veya istediginiz bir WebElemnt'in goruntusunu kolaylikla alabilirsiniz
        Asagidaki ornekte Amazon sayfasina gidip hem tum sayfanin hem de arama kutusunun fotografini aldim
        */

public class C07_ScreenShot {

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./tumSayfa.png"));

        File scrFile1 = aramaKutusu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("./aramaKutusu.png"));
    }
}

