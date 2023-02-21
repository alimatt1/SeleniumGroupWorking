package day5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Q1 extends TestBase {
    @Test
    public void test01(){
        // amazon adresine git
        driver.get("https://amazon.com");
        // tum kategoriler dropdowni locate et clik yap

        WebElement ddm=driver.findElement(By.xpath("//select[@data-nav-digest='Y2Ex0FDYtwBvLRafd9dRnatBcn4=']"));
        ddm.click();

        Select slct=new Select(ddm);
        // bulunan iceriklein listesini ve sayisini yazdirin
        System.out.println("DDM bulunan basliklar :"+slct.getOptions().size());

        List<WebElement> icerikList=slct.getOptions();
        int sirano=1;

        for (WebElement eachElement:icerikList){

            System.out.println(sirano+"=-=-=-"+eachElement.getText());
            sirano++;

        }
        // listesde "Software" bolumunun bulundugunu test edin
        String expected="Software";
        slct.selectByVisibleText("Software");
        String actual=slct.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);


        // index no ile arama yaoin
        System.out.println("index no10 :"+ slct.getOptions().get(10).getText());

        wait(2);
    }

    @Test
    public void test02(){
        driver.get("https://amazon.com");
        // elekteronik bolumunu secip arama boumue Macbook yazip sonuclari pahalidan ucuza seklind esiralip

        WebElement ddm =driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        ddm.click();
        Select select=new Select(ddm);
        select.selectByVisibleText("Electronics");
        select.getFirstSelectedOption().click();

        WebElement searcbox=driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("Macbook"+ Keys.ENTER);

        WebElement siralma=driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
        Select select1=new Select(siralma);

        select1.selectByVisibleText("Price: High to Low");
        //select1.getFirstSelectedOption().click();

        //en pahali urunun 40000 tlden daha yuksek oldunu test edin
        WebElement enpahaliUrun=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));

        String expectedFiyat="4,781";
        String actualfiyat=enpahaliUrun.getText();
        Assert.assertEquals(expectedFiyat,actualfiyat);
    }
}


//