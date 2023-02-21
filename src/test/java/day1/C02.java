package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // www.apple.com adresine gidin
        driver.get("https://www.trendyol.com");

        // sayfanin title ni getirin
        System.out.println(driver.getTitle());//

        // search bo;umunde Apple Watch aratin
        WebElement searchBox=driver.findElement(By.xpath("//div[@class='country-select']"));
        searchBox.click();

        WebElement bolgeSEcimi=driver.findElement(By.xpath("//option[@value='TR']"));
        bolgeSEcimi.click();

        WebElement select=driver.findElement(By.xpath("//*[@id=\"country-selection\"]/div/div/div[2]/div[4]/button"));
        select.click();



        //Apple Watch Ultra  aratin
        WebElement aramaBolumu=driver.findElement(By.xpath("//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/input"));
        aramaBolumu.sendKeys("Apple Watch Ultra" + Keys.ENTER);


        // fiyatiniin bilgisini getirin
        WebElement onerilen= driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[2]/select"));
        onerilen.click();
        WebElement enDusukFiyat=driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[2]/select/option[2]"));
        enDusukFiyat.click();

        WebElement enucuzSaat=driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[3]/div[1]/div/div[4]/div[1]/a/div[2]/div[4]"));
        enucuzSaat.click();

        //System.out.println("trendyol saat fiyati :"+driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div/div[5]/div[2]/div/span[2]")));

        WebElement seciliUrun=driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div[1]/div[2]/div[3]/div[1]/div/div[4]/div[1]/a/div[2]/div[4]"));
        seciliUrun.click();





        //butce 26000 tl eger bu fiyattan dusukse sepete ekle.




        // saatin fiyatini https://price.com/ da aratip
        // iki fiyattan hangisi daha uygunsa onun fiyatini getirin.
        // driveri kapatin

        //Thread.sleep(3000);
        driver.quit();


    }
}
