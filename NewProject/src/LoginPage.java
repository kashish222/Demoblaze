import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class LoginPage {
static String Username;
static String Password;
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
Username = driver.findElement(By.xpath("//body/div[@id='logInModal']/div[1]/div[1]/div[2]/form[1]/div[1]/label[1]")).getText();
System.out.println(Username);

Password = driver.findElement(By.xpath("//body/div[@id='logInModal']/div[1]/div[1]/div[2]/form[1]/div[2]/label[1]")).getText();
System.out.println(Password);

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
	    Username = driver.findElement(By.className("form-control-label")).getText();
	    if (Username.contentEquals("Username:"));
	    { System.out.println(true);}

	    Password = driver.findElement(By.className("form-control-label")).getText();
	    if (Password.contentEquals("Password:"));
	    {System.out.println(true);}
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
