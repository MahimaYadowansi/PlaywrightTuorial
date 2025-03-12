package learningPlaywright;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Login {

	public static void main(String[] args) {
		//This creates an instance of Playwright.
				Playwright playwright=Playwright.create(); 
				
				
				
				
				 // Launch WebKit browser
		        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		        Page page=browser.newPage();  //open new tab
		        page.navigate("https://ecommerce-playground.lambdatest.io/");
		       Locator myAccount=page.locator("//a[contains(.,'My account')][@role='button']") ; 
		       myAccount.hover();
		       
		       
		       Locator login=page.locator("//a[contains(. , ' Login')]") ; 
		       login.click();
		       page.getByPlaceholder("E-Mail Address").type("mahimayadowansi@gmail.com");
		       page.getByPlaceholder("Password").type("Mahima123@");
		       page.locator("//input[@value='Login']").click();

	}

}
