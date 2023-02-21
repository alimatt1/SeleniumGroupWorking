package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://www.automationexercise.com");

        //3. Verify that home page is visible successfully
        ////*[@id="header"]/div/div/div/div[1]/div/a/img
        WebElement logo=driver.findElement(By.xpath("//div[@class='logo pull-left']"));

        if (logo.isDisplayed()){
            System.out.println("anasayfa dogru goruntulendi");
        }else {
            System.out.println("anasayfa had not been visible successfully");
        }

        //4. Click on 'Signup / Login' button
        ////a[text()=' Signup / Login']
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement accountDurum= driver.findElement(By.xpath("//h2[text()='Login to your account']"));

        //6. Enter correct email address and password
        WebElement email=driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.sendKeys("taklatabilenkapikolu@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123456789");

        //7. Click 'login' button
        WebElement loginButtonu= driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        loginButtonu.click();

        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible



    }
}
