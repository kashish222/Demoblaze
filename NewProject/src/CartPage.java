import java.util.concurrent.TimeUnit;
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
public class CartPage {
	WebDriver driver;
	public static String nameString;
	public static String coString;
	public static String ciString;
	public static String creString;
	public static String monString;
	public static String yeString;
	public static String totalString;
	public static String resuString;
	
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
		 nameString=driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form/div[1]/label")).getText();
		 coString=driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form/div[2]/label")).getText();
		 ciString=driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form/div[3]/label")).getText();
		 creString=driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form/div[4]/label")).getText();
		 monString=driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form/div[5]/label")).getText();
		 yeString=driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]/form/div[6]/label")).getText();
		 totalString=driver.findElement(By.xpath("//*[@id=\"totalm\"]")).getText();
		 resuString=driver.findElement(By.xpath("/html/body/div[10]/h2")).getText();
		 Assert.assertTrue(nameString.contains("Name:"));
		 Assert.assertTrue(coString.contains("Country:"));
		 Assert.assertTrue(ciString.contains("City:"));
		 Assert.assertTrue(creString.contains("Credit card:"));
		 Assert.assertTrue(monString.contains("Month:"));
		 Assert.assertTrue(yeString.contains("Year:"));
		 Assert.assertTrue(totalString.contains("Total: 650"));
		 Assert.assertTrue(resuString.contains("Thank you for your purchase!"));
		
	 }
	    @AfterTest
	    public void aftertest(){
	        driver.close();
	    }
}


