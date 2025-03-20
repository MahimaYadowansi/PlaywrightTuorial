package handleAlert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnAlert {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		Locator allAlert=page.locator("text='Click Me'");
		page.onceDialog(alert->{
		   String message=alert.message();
		   System.out.println(message);
		   alert.accept();
		});
		allAlert.first().click();
		
		//2nd alert
		page.onceDialog(alert->{
			   String message=alert.message();
			   System.out.println(message);
			   alert.dismiss();
			});
			allAlert.nth(1).click();
			System.out.println(page.locator("#confirm-demo").textContent());
		
			
			//3rd alert
			page.onceDialog(alert->{
				   String message=alert.message();
				   System.out.println(message);
				   System.out.println(alert.defaultValue());
				   alert.accept("Mahima");
				   
				});
				allAlert.last().click();
			System.out.println(page.locator("#prompt-demo").textContent());
			
			
		page.waitForTimeout(3000);
		playwright.close();

	}

}
