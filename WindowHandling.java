package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		//click on open home page button
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Thread.sleep(3000);
		//Switch the window
		Set<String> windowHandle= driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandle);
		driver.switchTo().window(window.get(1));
		driver.close();
		//Switch to parent window
		Thread.sleep(300);
		driver.switchTo().window(parentWindow);
		//Click on multiple window
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandle2 = driver.getWindowHandles();
		List<String> window2= new ArrayList<String>(windowHandle2);
		driver.switchTo().window(window2.get(1));
		Thread.sleep(300);
		driver.manage().window().maximize();
		driver.switchTo().window(parentWindow);
		driver.quit();
		
	}

}
