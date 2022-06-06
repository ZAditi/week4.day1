package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//Enter Topic in the first frame
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Frame1");
		//select inner frame check box
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//Select value from the Animal dropdown
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		Thread.sleep(300);
		driver.switchTo().frame("frame2");
		WebElement dropDown =driver.findElement(By.id("animals"));
		Select dd = new Select(dropDown);
		dd.selectByVisibleText("Big Baby Cat");
	}

}
