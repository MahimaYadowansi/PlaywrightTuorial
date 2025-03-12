package simpleForms;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;  

public class SimpleForms {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		/*
		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		page.getByPlaceholder("Please enter your Message").type("Hey Tester");
		page.locator("#showInput").click();
		String message=	page.locator("#message").textContent();
		System.out.println(message);
	// assertThat(page.locator("#message")).hasText("Hey Tester");  
		
		
		//difference between type() and fill()
		page.navigate("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");
		page.locator("#textbox").type("Data entered in the below textarea will be download with file name 'Lambdainfo.txt'.");
		
		page.locator("#textbox").fill("Data entered in the below textarea will be download with file name 'Lambdainfo.txt'.");
		
		*/
		
		
		//read input value
	
		page.navigate("https://letcode.in/edit");
		String input =page.locator("#getMe").inputValue();
		System.out.println(input);
		Locator fullnamelocator=page.locator("#fullName");
		 assertThat(fullnamelocator.getAttribute("placeholder")).isEqualTo("Enter first & last name"); 
		assertThat(fullnamelocator).hasFieldOrPropertyWithValue("placeholder", "Enter first & last name");
		
		Locator fullNameLocator = page.locator("#fullName");
		String placeholderValue = fullNameLocator.getAttribute("placeholder");

		// JUnit assertion to check attribute value
		assertEquals("Enter first & last name", placeholderValue, "Mismatch in placeholder value!");
		
		
		
	//browser.close();
	//playwright.close();
	}

}
