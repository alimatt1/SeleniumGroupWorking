package mySelf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","Drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://websitesetup.org/website-usability/");

        //tagName[@attributeIsmi=‘attributeValue']
        ////*[@id="primary"]/section/div/form/input[1]
        WebElement searchBox= driver.findElement(By.xpath("//input[@aria-describedby='sizing-addon2']"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        driver.findElement(By.xpath("//a[@rel='bookmark']")).click();

        //
        //
        driver.findElement(By.className("icon-fb"));

        ////*[@id="widget-footer"]/div[1]/ul/li[1]/a/div/img


        Thread.sleep(4000);
        driver.close();




    }
}
