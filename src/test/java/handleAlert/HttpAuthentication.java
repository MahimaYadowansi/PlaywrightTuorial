package handleAlert;

import static org.assertj.core.api.Assertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HttpAuthentication {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		 BrowserContext context=browser.newContext(new Browser.NewContextOptions()
				  .setHttpCredentials("admin", "admin"));
		 Page page=context.newPage();
		 page.navigate("https://the-internet.herokuapp.com/basic_auth");
		 Locator sccessmessage=page.locator("//div[@id='content']//p");
		 System.out.println(sccessmessage.allTextContents());
		 assertThat(sccessmessage.allTextContents().equals("Congratulations! You must have the proper credentials."));
		 System.out.println("Authentication successful!");
		 
		 
		 
		 /*
		  * or
		  *  // Use getByText() since the text is unique
            Locator successMessage = page.getByText("Congratulations! You must have the proper credentials.");

            // Assert that the expected text is present
            assertThat(successMessage).isVisible();
*/
		 
		 page.waitForTimeout(3000);
		 page.close();
		 playwright.close();
		
	}

}
