package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndFrameActivity {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Aditi");
		prompt.accept();
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);

	}

}
