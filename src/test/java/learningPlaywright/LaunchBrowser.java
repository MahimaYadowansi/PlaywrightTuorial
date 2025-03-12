package learningPlaywright;



import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	public static void main(String[] args) {
		//This creates an instance of Playwright.
		Playwright playwright=Playwright.create();   
		
		//This launches a Chromium browser instance.
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
        Page page=browser.newPage();  //open new tab
        page.navigate("https://ecommerce-playground.lambdatest.io/");
       Locator myAccount=page.locator("//a[contains(.,'My account')][@role='button']") ; 
       myAccount.hover();
       
       
       Locator register=page.locator("//a[contains(. , ' Register')]") ; 
       register.click();
       
      
       page.getByPlaceholder("First Name").type("Mahima");
       page.getByPlaceholder("Last Name").type("Kumari");
       page.getByPlaceholder("E-Mail").type("mahimayadowansi@gmail.com");
       page.getByPlaceholder("Telephone").type("+91 9304718797");
       page.locator("//input[@placeholder='Password']").type("Mahima123@");
       page.locator("//input[@placeholder='Password Confirm']").type("Mahima123@");
       
       Locator checkbox=page.locator("//label[text()='I have read and agree to the ']") ; 
       checkbox.click();
       Locator continueBtn=page.locator("//input[@value='Continue']") ; 
       continueBtn.click();
      // assertThat(page).hasTitle("Your Account Has Been Created");
       
       browser.close();
       playwright.close();
	}

	
}
