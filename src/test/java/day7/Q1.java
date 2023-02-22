package day7;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q1 extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/download
        //        //LambdaTest elementini indirin indirdiginizi test edin
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("LambdaTest.txt")).click();

        wait(3);

        String dosyaYolu = System.getProperty("user.home") + "/Downloads/LambdaTest.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void test02() {
        //        //https://the-internet.herokuapp.com/upload baska bir tabda acin
        //        // masa ustunde veya download da bulunan bir dosyanin basarili bir sekilde  yuklendigini test edin.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://the-internet.herokuapp.com/upload");


        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/LambdaTest.txt";
        WebElement uploadButton = driver.findElement(By.id("file-upload"));
        uploadButton.sendKeys(dinamikDosyaYolu);
        wait(2);

        driver.findElement(By.id("file-submit")).click();

        WebElement fileUploadedYaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYaziElementi.isDisplayed());
        wait(5);
    }
    @Test
    public void test03(){
        //https://ultimateqa.com/
        // adresine gidin Learning blolumunun uzerine gelip Automation bolumunu secin
        // acilan sayfada fill out forms bolumune tiiklayin
        driver.get("https://ultimateqa.com/");
        WebElement learningBolumu=driver.findElement(By.linkText("Learning"));
        Actions action=new Actions(driver);

        action.moveToElement(learningBolumu).perform();
        driver.findElement(By.linkText("Automation Exercises")).click();

        driver.findElement(By.linkText("Fill out forms")).click();

        Faker faker=new Faker();


        // name ve message bolumleirne fake bilgilera isleyin ve submit yapin yapilan islemin basarili oldugunu test edin

        WebElement ilkBilgiBox=driver.findElement(By.id("et_pb_contact_name_0"));

        /*
        String toplamaislemi= driver.findElement(By.className("et_pb_contact_captcha_question")).getText();
        toplamaislemi.replaceAll(",","+");
        String[] arrTop=toplamaislemi.split("");

        int intislem=0;
        for (int i = 0; i < arrTop.length ; i++) {
            intislem+=Integer.parseInt(arrTop[i]);

        }
        String intIslemsonuc=intislem+"";

         */

        action.contextClick(ilkBilgiBox);
        action.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().paragraph())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName().toLowerCase())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().characters())
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //*[text()='Thanks for contacting us'][1]
        String expectedCikti="Thanks for contacting us";

        WebElement yazi1= driver.findElement(By.xpath("//*[text()='Thanks for contacting us'][1]"));
        //WebElement yazi2= driver.findElement(By.xpath("//*[text()='Thanks for contacting us'][2]"));

        Assert.assertTrue(yazi1.getText().contains(expectedCikti));
        //Assert.assertTrue(yazi1.getText().contains(expectedCikti) && yazi2.getText().contains(expectedCikti));

    }
}
