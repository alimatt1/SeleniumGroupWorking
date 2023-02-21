package day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase10 {
    //Test Case 10: Verify Subscription in home page
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @After
    public void gecis() throws InterruptedException {
        Thread.sleep(4000);

    }

    @Test
    public void test01(){
        driver.get("http://automationexercise.com");

        WebElement logo=driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(logo.isDisplayed());

        //6. Enter email address in input and click arrow button
        //7. Verify success message 'You have been successfully subscribed!' is visible
        //8. www.yourtube.com a gidin arama bolumunda Ahmet Bululuoz
        // 9. cilan sonuc bilgisini bize getirin
        // driveri kapatin
    }
    @Test
    public void test02(){
        //4. Scroll down to footer
        //5. Verify text 'SUBSCRIPTION'
        WebElement footer=driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(footer.isDisplayed());

    }

    @Test
    public void test03(){
        //6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("zerotwohero@gmail.com");
        //driver.findElement(By.id("subscribe_email")).sendKeys("zerotwohero@gmail.com");
        driver.findElement(By.id("subscribe")).click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message=driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']"));

        String expectedMessage="You have been successfully subscribed!";
        String actulalMessage=message.getText();

        Assert.assertEquals(expectedMessage,actulalMessage);

    }

    @Test
    public void test04() {
        //8. www.youtube.com a gidin arama bolumunda Ahmet Bululuoz
        // 9. cilan sonuc bilgisini bize getirin
        // driveri kapatin
    driver.get("https://www.youtube.com");

    driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")).sendKeys("Ahmet Bulutluoz"+ Keys.ENTER);

    WebElement pp=driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-channel-renderer/div/div[1]/a/div/yt-img-shadow/img"));
    pp.click();
    
    WebElement aboneSayisi= driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/div[3]/ytd-c4-tabbed-header-renderer/tp-yt-app-header-layout/div/tp-yt-app-header/div[2]/div[2]/div/div[1]/div/div[1]/yt-formatted-string[2]"));

    String aboneSayisiS=aboneSayisi.getText();
        System.out.println(aboneSayisiS);//

    double aboneSayisiD=Double.parseDouble(aboneSayisiS);
        System.out.println(aboneSayisiD);//

    Double expecteedD=8.0;

    Assert.assertFalse(aboneSayisiD<expecteedD);

    }

}




