package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Driver {
	private Playwright playwright;
	private Browser browser;
	private Page page;
	Driver(Playwright playwright,Browser browser,Page page )
	{
		this.playwright=playwright;
		this.browser=browser;
		this.page=page;
	}
	
	public Browser getBrowser()
	
	{
		return browser;
	}
	public Playwright getPlaywright()
	{
		return playwright;
	}
	public Page getPage()
	{
		return page;
	}

}
