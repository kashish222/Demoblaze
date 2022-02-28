import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class CartPage {
	WebDriver driver;
	 @BeforeTest
	    public void beforetest() {
		 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
         driver = new ChromeDriver();
	          driver.get("https://www.demoblaze.com/index.html");
	          driver.manage().window().maximize();
	    }
	 @Test
	 public void test() throws InterruptedException{
		 driver.findElement(By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/a[3]")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//body[1]/div[5]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/h4[1]/a[1]")).click();
		 driver.findElement(By.xpath("//body[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[1]")).click();
		 WebDriverWait wait = new WebDriverWait(driver, 6);
		 wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert = driver.switchTo().alert();
		 System.out.println(alert.getText());
		 alert.accept();
		 driver.findElement(By.id("cartur")).click();
		 Thread.sleep(300);
		 driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
		 Thread.sleep(300);
		 driver.findElement(By.id("name")).sendKeys("Charles Johnson");
		 Thread.sleep(300);
		 driver.findElement(By.id("country")).sendKeys("India");
		 Thread.sleep(300);
		 driver.findElement(By.id("city")).sendKeys("Ranchi");
		 Thread.sleep(300);
		 driver.findElement(By.id("card")).sendKeys("1400529083737");
		 Thread.sleep(300);
		 driver.findElement(By.id("month")).sendKeys("10");
		 Thread.sleep(300);
		 driver.findElement(By.id("year")).sendKeys("22");
		 Thread.sleep(300);
		 driver.findElement(By.xpath("//button[@onclick=\"purchaseOrder()\"]")).click();
		 Thread.sleep(500);
		 System.out.println("Purchase Successful!!");
	 }
	    @AfterTest
	    public void aftertest(){
	        driver.close();
	    }
}


