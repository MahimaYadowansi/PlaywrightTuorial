package recordVedio;


		import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.RecordVideoSize;

		public class VedioTests {
		  public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      
		      //to take vedio add new Browser.NewContextOptions().setRecordVedioDir(Paths.get("./Vedioes/LoginVedio/"))
		      BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("./Videos/LoginVideo/"))
		    		  .setRecordVideoSize(new RecordVideoSize(1280,720))); //for vedio clarity
		      Page page = context.newPage();
		      page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
		      Locator myAccount=page.locator("//a[contains(.,'My account')][@role='button']") ; 
		       myAccount.hover();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();

		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).fill("mahimayadowansi@gmail.com");

		 
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Mahima123@");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		      
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Edit your account")).click();

		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name*")).fill("Kumari");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
		  Locator message=    page.getByText("Success: Your account has");
		  assertThat(message).isVisible();
		  myAccount.hover();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout").setExact(true)).click();
		   Locator logoutMessage=   page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(" Account Logout"));
		   assertThat(logoutMessage);
		   page.close();
		   context.close();
		   browser.close();
		   playwright.close();
		   
		    }
		  }
		
	}

