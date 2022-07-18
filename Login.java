package week2.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Call a WDM
		WebDriverManager.chromedriver().setup();
		
		//Load a URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		
		//Maxmimize the browser
		driver.manage().window().maximize();
		
		//Find the username and enter the username value (demosalesmanager)
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		Thread.sleep(2000);

		//Find the password and enter the password value (crmsfa)
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(2000);

		//Click the Login button
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);

		//Finally, we need the check if we are correct page

		//Get the attribute and print
		System.out.println("Successfully Logged in");
		
		//Click the CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Create Lead")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Softeon");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Mugundan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K");
		
		WebElement dropdown1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropdown2 = new Select(dropdown1);
		
		dropdown2.selectByVisibleText("Employee");
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		String title = driver.getTitle();
		String titleName = "View Leads | opentaps CRM";
		
		if (title.equals(titleName)) {
			System.out.println("Successfully Completed: "+title);
		}
		

	}

}
