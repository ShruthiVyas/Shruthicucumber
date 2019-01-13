package creditCard;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class paymentgateway {
	WebDriver driver;
	@Given("The user is in demo.guru{int} payment gateway page initially")
	public void the_user_is_in_demo_guru_payment_gateway_page_initially(Integer int1) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nagarajan L\\eclipse-workspace\\creditCard\\src\\test\\java\\creditCard\\chromedriver.exe");   
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/payment-gateway/index.php");
	}
	@Given("The user navigates to generate card number tab and prints the details available")
	public void the_user_navigates_to_generate_card_number_tab_and_prints_the_details_available() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Generate Card Number']")).click();
		
		String pWId=driver.getWindowHandle();
		System.out.println(pWId);
		  Set<String>allWindowsId=driver.getWindowHandles();
		  System.out.println(allWindowsId);
		   for (String x: allWindowsId) {
			   if(!x.equals(pWId)) {
				   driver.switchTo().window(x);
				   
			   }
		   }
		  Thread.sleep(2000);
		  WebElement cardNo = driver.findElement(By.xpath("//h4[@style='text-align:center;font-size:24px;font-weight:400;color:#555;line-height:36px;'][1]"));
		   String name = cardNo.getText();
		   System.out.println(name);
		   
		   WebElement cVv=driver.findElement(By.xpath("//h4[contains (text(),'CVV')]"));
		   String name1 = cVv.getText();
		   System.out.println(name1);
		   
		   WebElement eXp=driver.findElement(By.xpath("//h4[contains (text(),'Exp')]"));
		   String name2 = eXp.getText();
		   System.out.println(name2);
		   
		   WebElement cardLimit=driver.findElement(By.xpath("//h4[contains (text(),'Credit Limit ')]"));
		   String name3 = cardLimit.getText();
		   System.out.println(name3); 
		   
	}
     
	@Given("The user navigates to check credit status tab enters the card number in the tab and clicks submit and prints the details .")
	public void the_user_navigates_to_check_credit_status_tab_enters_the_card_number_in_the_tab_and_clicks_submit_and_prints_the_details() throws InterruptedException {
	   Thread.sleep(2000);
		driver.get("http://demo.guru99.com/payment-gateway/check_credit_balance.php");
	    driver.findElement(By.xpath("//input[@id='card_nmuber']")).sendKeys("1234567812345678");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("The user navigates to cart and clicks on buy now")
	public void the_user_navigates_to_cart_and_clicks_on_buy_now() {
	    driver.get("http://demo.guru99.com/payment-gateway/purchasetoy.php");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("The user navigates to the payment process page and fill in the details and clicks on pay")
	public void the_user_navigates_to_the_payment_process_page_and_fill_in_the_details_and_clicks_on_pay() {
	    driver.findElement(By.xpath("//input[@id='card_nmuber']")).sendKeys("1234567812345678");
	  WebElement dDnmonth=  driver.findElement(By.xpath("//select[@name='month']"));
	    Select s=new Select(dDnmonth);
	    s.selectByIndex(2);
	    
	    WebElement dDnyear=  driver.findElement(By.xpath("//select[@name='year']"));
	    Select s1=new Select(dDnyear);
	    s1.selectByIndex(4);
	    
	    driver.findElement(By.xpath("//*[@id=\"cvv_code\"]")).sendKeys("123");
	    driver.findElement(By.xpath("//input[@value='Pay $20.00']")).click();
	    
	}

	@Then("The usser prints the success message")
	public void the_usser_prints_the_success_message() {
		WebElement pay=driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/h2"));	
		String name5 = pay.getText();
		System.out.println(name5);
	}

	
}
