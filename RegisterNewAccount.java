package MagentoTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RegisterNewAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//set property and driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp pc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//1-Navigate to “http://magento-demo.lexiconn.com/”
		driver.get("http://magento-demo.lexiconn.com/");
		
		//2-Go to “ACCOUNT” page
		driver.navigate().to("http://magento-demo.lexiconn.com/customer/account/");
		
		//3-Click on “Register” form
		WebElement Register = driver.findElement(By.linkText("Register")); //find the "Register" link
		Actions action = new Actions(driver); //using mouse actions to click on the link
		action.moveToElement(Register).click().build().perform();
		
		//4-Fill form data then click on “REGISTER” button
		WebElement FirstName = driver.findElement(By.id("firstname"));//find all the elements of the registration form
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.id("confirmation"));
		WebElement RegisterButton = driver.findElement(By.xpath("//button[@title='Register']"));
				
		
		FirstName.sendKeys("Jhon");//writing the data at registration form
		LastName.sendKeys("Doe");
		Email.sendKeys("Jhon@gmail.com");
		Password.sendKeys("123456");
		ConfirmPassword.sendKeys("123456");
		action.moveToElement(RegisterButton).click().build().perform(); //click on register button
		
		//5-Verify that the account was successfully registered
		String PageTitle = driver.getTitle();
		
		if (PageTitle.contentEquals("My Account")) //when user registered successfully, he will be redirected to "My account" page
		{
			System.out.println("Account is registered successfully!");
		}
		else
		{
			System.out.println("Registration failed");
		}

		
		
		
		
		
		
		
	}

}
