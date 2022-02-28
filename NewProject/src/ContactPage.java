import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactPage {
	WebDriver driver;
	 @BeforeTest
	    public void beforetest() {
		 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
         driver = new ChromeDriver();
         driver.get("https://www.demoblaze.com/index.html");}
	 @Test
     public void testmethod1() throws InterruptedException
     {
		 driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
		Thread.sleep(200);
     	driver.findElement(By.xpath("//input[@id='recipient-email']")).sendKeys("kashish@gmail.com");
     	driver.findElement(By.xpath("//input[@id='recipient-name']")).sendKeys("Kashish");
     	driver.findElement(By.xpath("//textarea[@id='message-text']")).sendKeys("I am facing some issues.");
     	driver.findElement(By.xpath("//button[@onclick='send()']")).click();
     	WebDriverWait wait1 = new WebDriverWait(driver, 6);
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
