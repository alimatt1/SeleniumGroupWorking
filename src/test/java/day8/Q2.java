package day8;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q2 extends TestBase {
    @Test
    public void test01(){
        ////https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login adrtesine
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        //    //bank maneger login butonuna tikla
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        //    //costumer bolumne tiklayin ve butun bilgileri yaydirin,
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
        WebElement tumBilgiler= driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']"));
        System.out.println(tumBilgiler.getText());

        //    "	E55555" posta lodlu musterinin oldugunu test edin
        String expectedPostaK="E55555";

        Assert.assertTrue(tumBilgiler.getText().contains(expectedPostaK));

        //    //bir geri gelin
        driver.navigate().back();

        //    // ad costumer bolumene tilayin
        driver.findElement(By.xpath("//button[@ng-class='btnClass1']")).click();

        //    // acilan pencerede ilgili yerlerie fake bilgiler ekleyin
        WebElement firsName= driver.findElement(By.xpath("//input[@ng-model='fName']"));
        firsName.click();
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
/*
        actions.contextClick(firsName)
                        .sendKeys(faker.name().firstName())
                        .sendKeys(Keys.TAB)
                        .sendKeys(faker.name().lastName())
                        .sendKeys(Keys.TAB)
                        .sendKeys(faker.address().zipCode())
                        .sendKeys(Keys.TAB)
                        .sendKeys(Keys.ENTER).perform();
        wait(3);
 */
        actions.contextClick(firsName)
                .sendKeys("Tomy")
                .sendKeys(Keys.TAB)
                .sendKeys("KEDI")
                .sendKeys(Keys.TAB)
                .sendKeys("8964243")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        wait(3);

        driver.switchTo().alert().accept();

        //    // musteri bilgi listesini tekrar yazdirin ve eklediginiz yeni musterinin listede oldugunu test edin
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
        tumBilgiler= driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']"));
        System.out.println(tumBilgiler.getText());
        String ExpectedIsim="Tomy";

        Assert.assertTrue(tumBilgiler.getText().contains(ExpectedIsim));

    }
}
