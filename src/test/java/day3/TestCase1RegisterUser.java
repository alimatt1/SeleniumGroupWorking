package day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase1RegisterUser {
    public static void main(String[] args) throws InterruptedException {

        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.id("header"));
        if (homePage.isDisplayed()){
            System.out.println("HOME PAGE IS VISIBLE SUCCESSFULLY");
        }
        //Assert.assertTrue("home Page is not visible",homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if (newUserSignUp.isDisplayed()){
            System.out.println("New User Sign Up! is visible ");
        }
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mike"+ Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mljaaqlh@telegmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInfo=driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        if (enterAccountInfo.isDisplayed()){
            System.out.println("ENTER ACCOUNT INFORMATION IS VISIBLE");
        }

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.xpath("//div[@class='clearfix']")).click(); //Title
        driver.findElement(By.xpath("// label[@for='id_gender1']")).click();
        driver.findElement(By.id("password")).sendKeys("12345678");

        driver.findElement(By.id("days")).sendKeys("20");
        driver.findElement(By.id("months")).sendKeys("November");
        driver.findElement(By.id("years")).sendKeys("1990");


        //10. Select checkbox 'Sign up for our newsletter!'
        //driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        //driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("mike");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("ekim");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("kime");
        driver.findElement(By.id("address1")).sendKeys("imek ave");
        //driver.findElement(By.id("address2")).sendKeys("");
        driver.findElement(By.id("country")).sendKeys("The USA");
        driver.findElement(By.id("state")).sendKeys("FLORIDA");
        driver.findElement(By.id("city")).sendKeys("MIAMI");
        driver.findElement(By.id("zipcode")).sendKeys("33161");
        driver.findElement(By.id("mobile_number")).sendKeys("+12345678900");

        //13. Click 'Create Account button'

        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


        Thread.sleep(5000);
        driver.close();
    }

}
