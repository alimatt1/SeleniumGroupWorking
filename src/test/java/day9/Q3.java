package day9;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Q3 extends TestBase {

    @Test
    public void test01() throws IOException, InterruptedException {
        driver.get("https://www.youtube.com");

        //driver.findElement(By.xpath("//div[@class='yt-spec-touch-feedback-shape__fill'])[11]"));

        //trending bolumune jsexecutor kullanarak scrooll yapin
        WebElement trending=driver.findElement(By.xpath("//span[text()='Trendler']"));

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView();",trending);

        //o sayfanin ekran goruntusunu alin

        TakesScreenshot tkss=(TakesScreenshot) driver;

        File alangoruntusu=new File("target/trending.jpeg");

        File geciciData=tkss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciData,alangoruntusu);

        //kapanmadan onve alert seklinde "islem basarili ile tamamlandi.:)"

        jse.executeScript("alert(islem basarili ile tamamlandi.:)");

        Thread.sleep(4000);

    }
}
