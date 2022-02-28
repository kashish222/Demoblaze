import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage {
WebDriver driver;
public static String phoneString;
public static String lapString;
public static String moniString;
		 @BeforeTest
		    public void beforetest() {
			 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		          driver = new ChromeDriver();
		          driver.get("https://www.demoblaze.com/index.html");
		          driver.manage().window().maximize();
		    }
		 @Test
		 public void test1()
		 {
			 phoneString=driver.findElement(By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/a[2]")).getText();
			 System.out.println(phoneString);
			driver.navigate().to("https://www.demoblaze.com/index.html");
			driver.findElement(By.linkText("Laptops")).click();
			 lapString=driver.findElement(By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/a[3]")).getText();
					 System.out.println(lapString);
					 driver.navigate().to("https://www.demoblaze.com/index.html");
					 driver.findElement(By.linkText("Monitors")).click();
					 moniString=driver.findElement(By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/a[4]")).getText();
					 System.out.println(moniString);
        if (phoneString.contentEquals("Phones")&&lapString.contentEquals("Laptops")&&moniString.contentEquals("Monitors"))
					 {
						 System.out.println("Test Passed");}}
		    @AfterTest
		    public void aftertest(){
		        driver.close();
		    }}