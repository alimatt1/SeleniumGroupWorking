package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        // https://www.mercedes-benz.com adresine gidin
        // search bolumune "S class" yazip aratin
        // sayfnin en alt bolumunde olan instagram linkine tiklayin
        // instagram linki acildiktan sonra kac tane takipcisi oldugunu bilgisini yazdirin
        // 5 saniye sonra driveri kapatin

        System.setProperty("Webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.mercedes-benz.com adresine gidin
        driver.get("https://www.trendyol.com");

        // search bolumune "starbucks" yazip aratin
        WebElement searchBox=driver.findElement(By.className("V8wbcUhU"));
        searchBox.sendKeys("starbucks"+ Keys.ENTER);



        Thread.sleep(3000);
        driver.close();


    }
}
