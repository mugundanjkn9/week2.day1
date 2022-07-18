package week2.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver chrome = new ChromeDriver();
		chrome.get("http://leaftaps.com/opentaps/control/login");
		chrome.manage().window().maximize();
		Thread.sleep(2000);
		chrome.findElement(By.id("username")).sendKeys("demosalesmanager");
		Thread.sleep(2000);
		chrome.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(2000);
		chrome.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
		
		chrome.findElement(By.linkText("CRM/SFA")).click();
		chrome.findElement(By.linkText("Leads")).click();
		chrome.findElement(By.linkText("Create Lead")).click();
		
		chrome.findElement(By.id("createLeadForm_companyName")).sendKeys("Softeon");
		chrome.findElement(By.id("createLeadForm_firstName")).sendKeys("Mugundan");
		chrome.findElement(By.id("createLeadForm_lastName")).sendKeys("K");
		chrome.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Kiba");
		chrome.findElement(By.id("createLeadForm_departmentName")).sendKeys("Reports");
		chrome.findElement(By.id("createLeadForm_description")).sendKeys("Working under Project Reports");
		chrome.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mugundanjkn9@gmail.com");
		
		WebElement statedrop = chrome.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select statecode =	new Select(statedrop);
		statecode.selectByVisibleText("New York");

		chrome.findElement(By.className("smallSubmit")).click();
		
		String title = chrome.getTitle();
		//System.out.println(chrome.getTitle());
		
		String titleName = "View Lead | opentaps CRM";
		
		if (title.equals(titleName)) {
			System.out.println("Successfully Completed: "+titleName);
		}
		
		Thread.sleep(2000);
		chrome.findElement(By.linkText("Duplicate Lead")).click();
		
		chrome.findElement(By.id("createLeadForm_companyName")).clear();
		chrome.findElement(By.id("createLeadForm_companyName")).sendKeys("Teatleaf");
		chrome.findElement(By.id("createLeadForm_firstName")).clear();
		chrome.findElement(By.id("createLeadForm_firstName")).sendKeys("Mugund");
		
		chrome.findElement(By.className("smallSubmit")).click();
		//System.out.println(chrome.getTitle());
		
		String newtitle = chrome.getTitle();
		String newtitleName = "View Lead | opentaps CRM";
		
		if (title.equals(newtitleName)) {
			System.out.println("Successfully Completed: "+newtitleName);
		}
		
	}
}
