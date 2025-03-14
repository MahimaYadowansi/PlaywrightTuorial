package windowHandles;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnWindowHandle {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.hyrtutorials.com/p/window-handles-practice.html");
		System.out.println(page.title()); //main page title
		
		//dealing with window handle
		Page newWindow =page.waitForPopup(()->{
		Locator newWindowBtn=page.locator("#newWindowBtn");
        newWindowBtn.click();
		});
		
		
		newWindow.waitForLoadState();
		assertThat(newWindow).hasTitle("Basic Controls - H Y R Tutorials");
		System.out.println(newWindow.title());
		
		Locator enterName=newWindow.locator("#firstName");
		
		enterName.type("Mahima");
		System.out.println("Name entered");
		newWindow.close();
		
		
		///dealing with multiple tabs
	/*	Page multiTab=page.waitForPopup(new page.WaitForPopupOptions()->
		{
			page.getByAltText("Follow By").click();
			
		});
		List<Page> countTab=multiTab.context().pages();
		System.out.println(countTab.size());
		countTab.forEach(Tabs->
		{
			System.out.println(Tabs.title());
		});*/
		
		
		
		
		
		
		
		playwright.close();
        
	}

}
