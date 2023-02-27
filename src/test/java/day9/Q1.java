package day9;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.security.Key;

public class Q1 extends TestBase {
    @Test
    public void test01() throws IOException {
        // 1-https://parabank.parasoft.com/parabank/index.htm
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        //email iconu na tiklayin
        driver.findElement(By.linkText("contact")).click();

        //Customer Care altindaki gerekli bilgileri dodurun ve islemi onaylayin
        WebElement nameElement=driver.findElement(By.xpath("//input[@id='name']"));

        Actions action=new Actions(driver);
        Faker faker=new Faker();
        action.contextClick(nameElement).sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.lorem().characters())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        wait(4);

        // Thank you  ifadesi ile baslayan cumlenin ciktigini test ediniz
        String actualIfade=driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[1]")).getText();

        String expectedIfade="Thank you";

        Assert.assertTrue(actualIfade.startsWith(expectedIfade));

        // ekran goruntusu aliniz

        TakesScreenshot tkss=(TakesScreenshot) driver;

        File ekrangoruntusu=new File("target/ParaBank.png");

        File geciciData=tkss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciData,ekrangoruntusu);


    }

}
