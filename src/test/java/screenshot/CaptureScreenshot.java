package screenshot;

import java.nio.file.Paths;
import java.util.List;

import java.util.Arrays; 

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

public class CaptureScreenshot {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
//when deal with screenshot we have to close playwright and browser otherwise it won't work
		
		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		//screenshot only visible portion(not fullpage)
		ScreenshotOptions screenshot1=new ScreenshotOptions();
		page.screenshot(screenshot1.setPath(Paths.get("./snaps/scr.png")));
		
		
		//screenshot of full page
		page.screenshot(screenshot1.setFullPage(true).setPath(Paths.get("./snaps/Fullscr.png")));
		
		
		
		//Locator screenshot
		Locator bookBtn=page.locator("//button[text()='Book a Demo']");
		bookBtn.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/Locator.png")));
		
		
	Locator header=page.locator("#header");
	header.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/header.png")));
		
		//Masking of locator(Hide input data and then send screenshot
	Locator inputbox=page.locator("#sum2");
	
	/*
	inputbox.type("Mahima");
	inputbox.scrollIntoViewIfNeeded();  //if page doesn't scoll
	page.screenshot(screenshot1.setPath(Paths.get("./snaps/maskedInput.png")).setFullPage(false).setMask(Arrays.asList(inputbox))); 
	*/
	//caret hide/show(blinking cursor in inputbox
	inputbox.click();
	//page.screenshot(new ScreenshotOptions().setCaret(ScreenshotCaret.HIDE).setPath(Paths.get("./snaps/hideCaret.png")));
	//to show
	page.screenshot(new ScreenshotOptions().setCaret(ScreenshotCaret.INITIAL).setPath(Paths.get("./snaps/ShowCaret.png")));
	
		
		
		
		page.close();
		browser.close();
		playwright.close();
		
	}

}
