package runningOnCloud;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasicLoginDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
	JsonObject capabilities=new JsonObject();
	JsonObject ltOptions=new JsonObject();
	String user=System.getenv("LambdaTestUserId");
	String accessKey=System.getenv("LambdaTestAccessKey");
	System.out.println	(user);		
	System.out.println(accessKey);
	 ltOptions.addProperty("username", user);
     ltOptions.addProperty("accessKey", accessKey);
     ltOptions.addProperty("platform", "Windows 10"); 
     ltOptions.addProperty("browser", "chrome");
     ltOptions.addProperty("build", "Playwright Java Build 2");
     ltOptions.addProperty("name", "Playwright Test");

     capabilities.add("LT:Options", ltOptions);

     // Playwright Test
     Playwright playwright = Playwright.create();
     BrowserType chromium = playwright.chromium();
     String caps = URLEncoder.encode(capabilities.toString(), "UTF-8");

     // WebSocket URL
     String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + caps;
     System.out.println("Connecting to: " + cdpUrl);

     Browser browser = chromium.connect(cdpUrl);
     Page page = browser.newPage();
			try {
				
				page.navigate("https://duckduckgo.com/");
				Locator search=page.locator("//input[@name=\"q\"]");
				search.click();
				search.fill("LambdaTest");
				page.keyboard().press("Enter");
				String title=page.title();
				if(title.equals("LambdaTest at DuckDuckGo"))
				{
					setTestStatus("Passed","Title matched",page);
				}
				else {
					setTestStatus("Faild","Title not matched",page);
				}
				
			}catch(Exception e)
			{
				setTestStatus("Faild",e.getMessage(),page);
				e.printStackTrace();
			}
			
			browser.close();
			playwright.close();
			

	}

	private static void setTestStatus(String status, String remark, Page page) {
		page.evaluate("() => {}", "lambdatest_action: { \"action\": \"setTestStatus\", \"arguments\": { \"status\": \"" + status + "\", \"remark\": \"" + remark + "\"}}");
		
	}

}
