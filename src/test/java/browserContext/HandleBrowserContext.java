package browserContext;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
public class HandleBrowserContext {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		 BrowserContext context=browser.newContext();
		 Page page=context.newPage();
		page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		page.getByLabel("E-Mail Address").type("mahimayadowansi@gmail.com");
		page.getByLabel("Password").type("Mahima123@");
		 page.locator("//input[@value='Login']").click();
		//page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
		Locator myAccount=page.getByText("Edit your account information");
	assertThat(myAccount).isVisible();
	
	
	//open new tab
	Page newTab=page.context().newPage();  //new page from same context(same session shared)
	newTab.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
	assertThat(myAccount).isVisible();
	
	//Open new context
	BrowserContext context2=browser.newContext();
	Page page2=context.newPage();
	//it is new context so it should be rediredirected to login page.
	page2.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
	
	
	
		

	}

}
