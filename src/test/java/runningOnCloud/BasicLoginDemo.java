package runningOnCloud;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;

import com.google.gson.Gson;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasicLoginDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/*JsonObject capabilities = new JsonObject();
		JsonObject ltOptions = new JsonObject();
		// features (like WebSockets for Playwright) might be restricted in the free
		// plan of lambdaTest
		String user = System.getenv("LambdaTestUserId");
		String accessKey = System.getenv("LambdaTestAccessKey");
		System.out.println(user);
		System.out.println(accessKey);
		ltOptions.addProperty("username", user);

		ltOptions.addProperty("accessKey", accessKey);
		ltOptions.addProperty("platform", "Windows 10");
		ltOptions.addProperty("browser", "chrome");
		ltOptions.addProperty("build", "Playwright Java Build 2");
		ltOptions.addProperty("name", "Playwright Test");
		ltOptions.addProperty("accessibility", true);
		ltOptions.addProperty("w3c", true);
		ltOptions.addProperty("project", "demo lambdatest");
		ltOptions.addProperty("visual", true);
		ltOptions.addProperty("video", true);
		ltOptions.addProperty("network", true);
		ltOptions.addProperty("tunnel", true);
		ltOptions.addProperty("console", "true");
		ltOptions.addProperty("selenium_version", "4.0.0");
		ltOptions.addProperty("geoLocation", "AU");
		;

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
			Locator search = page.locator("//input[@name=\"q\"]");
			search.click();
			search.fill("LambdaTest");
			page.keyboard().press("Enter");
			String title = page.title();
			if (title.equals("LambdaTest at DuckDuckGo")) {
				setTestStatus("Passed", "Title matched", page);
			} else {
				setTestStatus("Faild", "Title not matched", page);
			}

		} catch (Exception e) {
			setTestStatus("Faild", e.getMessage(), page);
			e.printStackTrace();
		}

		browser.close();
		playwright.close();

	}*/
		
		
		
		
		//capabilities generator
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "mahima27kumari");
		ltOptions.put("accessKey", "LT_LvcQc1MkrVsOYjNkTTECTju9wkk4hg3Eu5E8LtMEB3jVW30");
		ltOptions.put("geoLocation", "AR");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("resolution", "1280x1024");
		ltOptions.put("seCdp", true);
		ltOptions.put("network", true);
		ltOptions.put("timezone", "Bamako");
		ltOptions.put("build", "build 3");
		ltOptions.put("project", "Playwright lambdatest");
		ltOptions.put("name", "Playwright cloud test");
		ltOptions.put("tunnel", true);
		ltOptions.put("console", "true");
		ltOptions.put("networkThrottling", "Regular 4G");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-java");
		ltOptions.put("accessibility", true);
		browserOptions.setCapability("LT:Options", ltOptions);
		 // Convert HashMap to JSON string
        Gson gson = new Gson();
        String capabilities = gson.toJson(ltOptions);
        String capsEncoded = URLEncoder.encode(capabilities, "UTF-8");

        // WebSocket URL for Playwright
        String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + capsEncoded;
        System.out.println("Connecting to: " + cdpUrl);

        // Start Playwright
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        try {
            Browser browser = chromium.connect(cdpUrl);
            Page page = browser.newPage();

            // Perform actions on the page
            page.navigate("https://duckduckgo.com/");
            Locator search = page.locator("//input[@name=\"q\"]");
            search.click();
            search.fill("LambdaTest");
            page.keyboard().press("Enter");

            // Validate title
            String title = page.title();
            if (title.equals("LambdaTest at DuckDuckGo")) {
                setTestStatus("Passed", "Title matched", page);
            } else {
                setTestStatus("Failed", "Title not matched", page);
            }

            // Close browser
            browser.close();
            playwright.close();

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
		
		
		
		
		

	private static void setTestStatus(String status, String remark, Page page) {
		page.evaluate("() => {}", "lambdatest_action: { \"action\": \"setTestStatus\", \"arguments\": { \"status\": \""
				+ status + "\", \"remark\": \"" + remark + "\"}}");

	}

}
