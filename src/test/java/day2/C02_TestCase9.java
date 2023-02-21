package day2;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TestCase9 {
    public static void main(String[] args) throws InterruptedException {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo=driver.findElement(By.xpath("//div[@class='logo pull-left']"));

        if (logo.isDisplayed()){
            System.out.println("anasayfa dogru goruntulendi");
        }else {
            System.out.println("anasayfa had not been visible successfully");
        }

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully

        WebElement allProduct=driver.findElement(By.xpath("//h2[text()='All Products']"));

        if (allProduct.isDisplayed()){
            System.out.println("Tum urunler goruntulendi");
        }

        //6. Enter product name in search input and click search button
        WebElement searchBox=driver.findElement(By.id("search_product"));
        searchBox.sendKeys("Polo"+ Keys.ENTER);


        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        if (searchedProducts.isDisplayed()){
            System.out.println("SEARCHED PRODUCTS' is visible");
        }

        //8. Verify all the products related to search are visible
        WebElement aramaSonuc=driver.findElement(By.xpath("(//h2[text()='Rs. 1500'])[1]"));

        if (aramaSonuc.isEnabled()){
            System.out.println("arama sonuclari visible");
        }


        Thread.sleep(4000);
        driver.close();

    }
}
