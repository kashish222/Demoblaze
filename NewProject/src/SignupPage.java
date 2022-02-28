import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignupPage {
	WebDriver driver;
	static String Username;
	static String Password;
	 @BeforeTest
	    public void beforetest() {
		 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
         driver = new ChromeDriver();
	          driver.get("https://www.demoblaze.com/index.html");
	          driver.manage().window().maximize();
	    }
	    @AfterTest
	    public void aftertest(){
	        driver.close();
	    }
	    @Test(priority = 1)
	    public void test() throws InterruptedException {
	    	driver.findElement(By.id("signin2")).click();
	    	Username = driver.findElement(By.className("form-control-label")).getText();
	    	if (Username.contentEquals("Username:"));
	    	{ System.out.println(true);}
	    	Password = driver.findElement(By.className("form-control-label")).getText();
	    	if (Password.contentEquals("Password:"));
	    	{System.out.println(true);}
	    	Thread.sleep(200);
	    	
	    	//By giving valid user-name and password
	    	driver.findElement(By.id("sign-username")).sendKeys("Lucky");
	    	
	    	driver.findElement(By.id("sign-password")).sendKeys("Youaredifferent");
	    	driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
	    	WebDriverWait wait = new WebDriverWait(driver, 6);
	    	wait.until(ExpectedConditions.alertIsPresent());
	    	Alert alert = driver.switchTo().alert();
	    	System.out.println(alert.getText());
	    	alert.accept();
	    }
	    @Test(priority = 2)
	    public void test1() throws InterruptedException {
	    	driver.navigate().to("https://www.demoblaze.com/index.html");
	    	driver.manage().window().maximize();
	    	driver.findElement(By.id("signin2")).click();
	    	Username = driver.findElement(By.className("form-control-label")).getText();
	    	if (Username.contentEquals("Username:"));
	    	{ System.out.println(true);}

	    	Password = driver.findElement(By.className("form-control-label")).getText();
	    	if (Password.contentEquals("Password:"));
	    	{System.out.println(true);}
                   //By giving invalid user-name
	    	Thread.sleep(200);
	    	driver.findElement(By.id("sign-username")).sendKeys("696917//");
	    	driver.findElement(By.id("sign-password")).sendKeys("Johnson143");

	    	driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 6);
	    	wait.until(ExpectedConditions.alertIsPresent());
	    	Alert alert = driver.switchTo().alert();
	    	System.out.println(alert.getText());
	    	alert.accept();


	    }
}

