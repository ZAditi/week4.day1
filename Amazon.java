package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		//search one plus 9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		//click on search
		driver.findElement(By.id("nav-search-submit-button")).click();
		//get price
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Price:" +price);
		//Get rating
		String rating = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro']")).getText();
		System.out.println("Rating: "+ rating);
		//Click on first link
		driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
		//Switch window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		//Take Screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./phone.png");
		FileUtils.copyFile(source, destination);
		//Click on add to cart
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		//Print the cart subtotal
		Thread.sleep(3000);
		String subtotal = driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price a-text-bold')]/span")).getText();
	    System.out.println("Subtotal of the cart: "+ subtotal);
	    //verify if the total is correct
		if(subtotal.contains(price)) {
			System.out.println("Cart Subtotal is correct:" + price);
		}
		else
		{
			System.out.println("Sub total does not match");
		}
		//close the browser
		driver.quit();
	}

}
