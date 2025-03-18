// command to run in terminal
	//>mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://ecommerce-playground.lambdatest.io/index.php?route=common/home"

package playwightInspector;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;


public class LearnPlaywrightInspector {
	public static void main(String[] args) {
	try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
	      
	      page.pause(); //act as debug point. Whenever you want to pause in page use this.
	      
	      
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" My account")).click();
	     
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).fill("mahimayadowansi@gmail.com");

	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Mahima123@");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	      
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("All Categories")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Laptops").setExact(true)).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search For Products")).click();

	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search For Products")).fill("Dell laptop");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
	     Locator discount= page.locator("//label[text()='10% off or more']").first();
	     discount.scrollIntoViewIfNeeded();
	     discount.click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" My account")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Logout")).click();
	      Locator logoutMessage=page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(" Account Logout"));
	      assertThat(logoutMessage);
		   page.close();
	       browser.close();
		  playwright.close();
	  }
	}
}
