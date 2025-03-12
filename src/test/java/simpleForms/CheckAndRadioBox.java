package simpleForms;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static org.assertj.core.api.Assertions.assertThat; 
public class CheckAndRadioBox {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		Locator isAge=page.locator("#isAgeSelected");
		 // Assert that checkbox is not checked
        assertThat(isAge.isChecked()).isFalse();  

        // Click the checkbox
        isAge.click();

        // Assert that checkbox is checked
        assertThat(isAge.isChecked()).isTrue();  


	}

}
