package VD;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google {

	public static WebDriver driver;
	
	@Test
	public void DynamicGoggleSearch() {
		

		System.setProperty("webdriver.chrome.driver", "E:\\CCC\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver= new ChromeDriver();
				
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@title=\"Search\"]")).sendKeys("Testing");
		List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']/li//descendant::div[@class='sbl1']"));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			
			System.out.println(list.get(i).getText());
			String name= list.get(i).getText();
			
			
			if(name.equals("testing powder")) {
				list.get(i).click();
			}
		}
		
	}
}
