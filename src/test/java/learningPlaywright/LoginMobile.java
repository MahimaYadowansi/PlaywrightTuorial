package learningPlaywright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginMobile {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

        // Get the iPhone 12 device descriptor
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = playwright.webkit().launch(launchOptions);
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setViewportSize(390, 530) // iPhone 12 viewport
            .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/537.36 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/537.36") // iPhone 12 User-Agent
            .setDeviceScaleFactor(3) // Scale factor for high-res mobile screens
            .setHasTouch(true) // Enable touch input
        );

        Page page = context.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/");

        // Login steps
        Locator myAccount = page.locator("//a[contains(.,'My account')][@role='button']");
        myAccount.hover();
        Locator login = page.locator("//a[contains(. , ' Login')]");
        login.click();
        page.getByPlaceholder("E-Mail Address").type("mahimayadowansi@gmail.com");
        page.getByPlaceholder("Password").type("Mahima123@");
        page.locator("//input[@value='Login']").click();
    }
}