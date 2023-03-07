package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) {
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Rajina");
		driver.findElement(By.name("lastname")).sendKeys("Chandran");
		driver.findElement(By.name("reg_email__")).sendKeys("9112345678");
		driver.findElement(By.id("password_step_input")).sendKeys("Rajina_Chandran");
		WebElement day = driver.findElement(By.id("day"));
		Select drop1= new Select(day);
		drop1.selectByVisibleText("7");
		WebElement month = driver.findElement(By.id("month"));
		Select drop2=new Select(month);
		drop2.selectByIndex(2);
		WebElement year = driver.findElement(By.id("year"));
		Select drop3=new Select(year);
		drop3.selectByValue("2000");
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		driver.close();
}
}

