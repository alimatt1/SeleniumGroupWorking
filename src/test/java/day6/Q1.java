package day6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseClass;

import java.util.List;

public class Q1 extends TestBaseClass {

    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //cizgili alan uzerine sag click yapin ve alerti onaylayin
        WebElement cizgiliAlanELementi = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(cizgiliAlanELementi).perform();
        driver.switchTo().alert().accept();

        //ana sayfada "Context Menu" yazdigini test edin
        WebElement contextMenuElementi = driver.findElement(By.xpath("//*[text()='Context Menu']"));
        String expextedYazi = "Context Menu";
        String actualYazi = contextMenuElementi.getText();

        Assert.assertEquals(expextedYazi, actualYazi);
        wait(3);

        String ilkSayfaWHD = driver.getWindowHandle();

        //Ikinci bir sayfada youtube a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String ikinciSayfaWHD = driver.getWindowHandle();


        //arama bolumunde "Java" aratin, cikan videolarin baslik kisminda "String" ifadesi bulundugunu test edin
        WebElement aramaBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        aramaBox.click();
        aramaBox.sendKeys("Java" + Keys.ENTER);

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));

        String expectedTitle = "String";
        /*int baslikSayisi = 1;

        for (WebElement eachElement : basliklarListesi) {
            System.out.println(baslikSayisi + "." + eachElement.getText());
            Assert.assertTrue("string testi FAILED",eachElement.getText().contains(expectedTitle));
            baslikSayisi++;
        */

        //https://demoqa.com/droppable adresine gidin ve accept bolumune tiklayin\
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://demoqa.com/droppable");

        driver.findElement(By.linkText("Accept")).click();

        //acceptable elementini drop here bolumune surukleyin ve cikan yazinin "Dropped!" oldugunu tset edin
        WebElement dragObj= driver.findElement(By.id("acceptable"));
        WebElement dropOBj=driver.findElement(By.xpath("(//div[@id='droppable'])[2]"));
        action.dragAndDrop(dragObj,dropOBj).perform();

        String expectedYazi= "Dropped!";
        String actualyazi= driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

        Assert.assertEquals(expectedYazi,actualyazi);
        wait(3);


        // youtube a don ve ana sayfada youtube ambleminin gozuktugunu test edin
        driver.switchTo().window(ikinciSayfaWHD);
        WebElement youtubeLogo=driver.findElement(By.xpath("//*[@id='logo-icon'][1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());

        //baslangic sayfamiza donup test islemini tamamlayiniz
        driver.switchTo().window(ilkSayfaWHD);


    }
}
