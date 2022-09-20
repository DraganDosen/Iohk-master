package android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import Pages.CastVotesPage;
import Pages.MySelectionPage;
import Pages.ProposalPage;
import Pages.SmokeTestPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SmokeTest {
	AndroidDriver<AndroidElement> driver;

	@Test(priority = 0)

	public void smokeTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		SecretsKeys key = new SecretsKeys();
		caps.setCapability("browserstack.user", key.User);
		caps.setCapability("browserstack.key", key.Password);
		caps.setCapability("app", key.App);

		// Specify device and os_version for testing
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "Java Project");
		caps.setCapability("build", "Java Android");
		caps.setCapability("name", "Smoke Test");

		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		AndroidDriver<AndroidElement> drivers = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), caps);
		System.out.println("Smoke tests: ");
		driver = drivers;
	}

	@Test(priority = 1, description = "Go To Dashboard")
	public void goToDashboardTest() throws InterruptedException {
		SmokeTestPage stObj = new SmokeTestPage(driver);

		stObj.buttonSkip();
		stObj.enrollButton();
		stObj.closePopup();
		stObj.checkDashboard();
		stObj.driverReturn();

	}

	@Test(priority = 2, description = "Go To MySelection")
	public void goToMySelectionTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Go To My Selection Test");
		MySelectionPage msObj = new MySelectionPage(driver);
		msObj.goMySelection();
		msObj.driverReturn();
	}

	@Test(priority = 3, description = "Go To Cast Votes")
	public void CastVotesTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Go To My Selection Test");
		CastVotesPage cvObj = new CastVotesPage(driver);
		cvObj.goCastVotes();
		cvObj.driverReturn();
	}

	@Test(priority = 3, description = "Go To Help and Support")
	@Severity(SeverityLevel.CRITICAL)
	public void helpAndSupportTest() throws InterruptedException {
		SmokeTestPage dp = new SmokeTestPage(driver);

		dp.goHelpAndSupport();
		dp.driverReturn();
	}

	@Test(priority = 6, description = "Go To proposal")
	@Severity(SeverityLevel.CRITICAL)
	public void goToProposalTest() throws InterruptedException {
		ProposalPage proposalPageObj = new ProposalPage(driver);

		proposalPageObj.goInProposal();
		proposalPageObj.driverReturn();
	}

}
