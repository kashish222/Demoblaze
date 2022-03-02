import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class LoginPage {
static boolean Username;
static boolean Password;
	WebDriver driver;
	 @BeforeTest
	    public void beforetest() {
		 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
         driver = new ChromeDriver();
	          driver.get("https://www.demoblaze.com/index.html"); 
	    }
	    @Test
public  void test() throws InterruptedException
{
	    	driver.manage().window().maximize();
driver.findElement(By.id("login2")).click();
Username=driver.findElement(By.xpath("//label[@for='log-name']")).isEnabled();
Password=driver.findElement(By.xpath("//label[@for='log-pass']")).isEnabled();
Assert.assertTrue(Username);
Assert.assertTrue(Password);




WebDriverWait wait = new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
//valid user-name and password
driver.findElement(By.id("loginusername")).sendKeys("Charles Johnson");
Thread.sleep(200);

driver.findElement(By.id("loginpassword")).sendKeys("Johnson143");
Thread.sleep(200);

driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[3]/button[2]")).click();
System.out.println("Login Successful!");


}
	    @Test
	    public  void test1() throws InterruptedException
	    {
	    	driver.navigate().to("https://www.demoblaze.com/index.html");
	    driver.findElement(By.id("login2")).click();
	    Username=driver.findElement(By.xpath("//label[@for='log-name']")).isEnabled();
	    Password=driver.findElement(By.xpath("//label[@for='log-pass']")).isEnabled();
	    Assert.assertTrue(Username);
	    Assert.assertTrue(Password);
	    WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
	    //leaving  user-name blank and providing only password
	    driver.findElement(By.id("loginpassword")).sendKeys("Johnson143");
	    Thread.sleep(200);

	    driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
	    WebDriverWait wait1 = new WebDriverWait(driver, 10);
     	wait1.until(ExpectedConditions.alertIsPresent());
     	Alert alert = driver.switchTo().alert();
     	System.out.println(alert.getText());
     	alert.accept();
}
	    @AfterTest     
	    public void aftertest(){
	        driver.close();
	    }
}