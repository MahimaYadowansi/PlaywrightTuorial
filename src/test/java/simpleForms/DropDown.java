package simpleForms;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class DropDown {

	public static void main(String[] args) {
		String selectUrl="https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
		String JQueryUrl="https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo";
		Page page=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false)).newPage();
		/*
		page .navigate(selectUrl);
		
		//setect by value
		page.locator("#select-demo").selectOption("Monday");
		Locator drop=page.locator("#select-demo");
         drop.selectText();
         Locator result=page.locator("p.selected-value");
         System.out.println(result.textContent());
         assertThat(result).containsText("Monday");
         
         //select by lable
         drop.selectOption(new SelectOption().setValue("Friday"));
         System.out.println(result.textContent());
         assertThat(result).containsText("Friday");
         
         
         //select by index
         drop.selectOption(new SelectOption().setIndex(2));
         System.out.println(result.textContent());
         
         
         
         //multiple value
         Locator multidrop=page.locator("#multi-select");
         multidrop.selectOption(new String[] {"California","Ohio"});
         Locator optioncount=multidrop.locator("option");
         System.out.println(optioncount.count());
         List<String> allInnerText=optioncount.allInnerTexts();
         allInnerText.forEach(optioncounts ->System.out.println(optioncounts));
         
         */
		
		//deal with jquery
		page.navigate(JQueryUrl);
		Locator Country=page.locator("span.select2-container").first();
		Country.click();
		Locator selectCountry=page.locator("span.select2-results ul li" , new Page.LocatorOptions().setHasText("India"));
		selectCountry.click();
		
	}

}
