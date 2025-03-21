package pomTests;

import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.LoadState;

import base.Driver;
import base.PlaywrightConnection;
import pomPages.MyAccountPage;
import pomPages.RegisterAccountPage;

public class RegistrationTest extends PlaywrightConnection{
	Driver driver;
	@BeforeMethod
	public void setUp() throws Exception {
			driver = super.createConnection();
	}
	@AfterMethod
	public void tearDown() {
		super.closeConnection(driver);
	}
	
	@Test
	public void registerUSer() {
		Page page = driver.getPage();
		MyAccountPage header = new MyAccountPage(page);
		RegisterAccountPage register = new RegisterAccountPage(page);
		try {
			page.navigate("https://ecommerce-playground.lambdatest.io/");
			page.waitForLoadState(LoadState.LOAD);
			header.clickRegister();
			register.clickContinue();
			boolean warningVisible = register.isWarningVisible();
			if(warningVisible) {
				super.setTestStatus("passed","Warning is visible", page);
			}else {
				super.setTestStatus("failed", "Warning is not visible", page);
			}
			int mandatoryWarningMessageVisible = register.isMandatoryWarningMessageVisible();
			if(mandatoryWarningMessageVisible > 0) {
				super.setTestStatus("passed","All mandatory fields are visible", page);
			}
			String email = "mahima"+new Date().getTime()+"@mail.com";
			register.registerUserAccount("Mahima", "C",email, "1234567890", "Mahima123@");
			String registterSuccess = register.isRegistterSuccess();
			page.waitForTimeout(5000);
			if(registterSuccess.equals("Your Account Has Been Created!")) {
				super.setTestStatus("passed","Register success", page);
			}else {
				super.setTestStatus("failed", "Register failed", page);
			}
		} catch (PlaywrightException err) {
			super.setTestStatus("failed", err.getMessage(), page);
			err.printStackTrace();
		}
	}
}
