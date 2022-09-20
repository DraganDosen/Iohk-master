package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import static org.junit.Assert.*;
import io.appium.java_client.pagefactory.AndroidFindBy;
import android.SecretsKeys;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static org.junit.Assert.assertEquals;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProposalPage extends BasePage {
	// public class DashboardPage {
	AndroidDriver<AndroidElement> driver;
	public WebDriverWait wait;

	public ProposalPage(AndroidDriver<AndroidElement> driver) {
		// super(driver);
		this.driver = driver;
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void goInProposal() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement goToProposal = driver.findElement(By.xpath("\r\n"
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]"));
		goToProposal.click();

		List<AndroidElement> vrfProposal = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement vrfProp : vrfProposal) {

			System.out.println(vrfProp.getText());
			if (vrfProp.getText().equals("Proposals")) {
				assertEquals(vrfProp.getText(), "Proposals");
				System.out.println("Proposals is opened");
				Reporter.log("Proposals is opened");
				break;
			}
			Thread.sleep(3000);
		}
	}

	public void minThreeLettersForSearchChallenges() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement editSearchChallenges = driver.findElement(By.className("android.widget.EditText"));
		AndroidElement searchButton = driver.findElement(By.xpath("//android.widget.Button[@text='search']"));
		editSearchChallenges.sendKeys("Th");
		Thread.sleep(1000);
		if (!searchButton.isEnabled()) {
			assert false;
		}
		editSearchChallenges.clear();
		editSearchChallenges.sendKeys("The Great Migration (from Etherium)");
		Thread.sleep(1000);
		if (!searchButton.isEnabled()) {
			assert false;
		}
		editSearchChallenges.clear();
	}

	public void searchChallenges() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		AndroidElement editSearchChallenges = driver.findElement(By.className("android.widget.EditText"));
		AndroidElement searchButton = driver.findElement(By.xpath("//android.widget.Button[@text='search']"));

		editSearchChallenges.clear();
		editSearchChallenges.sendKeys("The Great Migration (from Etherium)");

		searchButton.click();
		Thread.sleep(2000);

		List<AndroidElement> alltextinchallenges = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement el : alltextinchallenges) {

			if (el.getText().equals("Community CIP Editor: 1 year budget")) {
				System.out.println("Challenges search doesn't work");
				Reporter.log("Challenges search doesn't work");
				assert false;
				// Thread.sleep(2000);

			}
		}

		AndroidElement theGreatMigration = driver
				.findElement(By.xpath("//android.widget.TextView[@text='The Great Migration (from Ethereum)']"));
		theGreatMigration.click();
		Thread.sleep(1000);
		AndroidElement theGreatMigrationChallenge = driver
				.findElement(By.xpath("//android.widget.TextView[@text='The Great Migration (from Ethereum)']"));
		if (!theGreatMigrationChallenge.isDisplayed()) {
			assert false;
		}

	}

	public void searchProposal() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement editSearchProposal = driver.findElement(By.className("android.widget.EditText"));
		AndroidElement searchButton = driver.findElement(By.xpath("//android.widget.Button[@text='search']"));
		editSearchProposal.clear();
		editSearchProposal.sendKeys("Community CIP Editor: 1 year budget");
		searchButton.click();
		Thread.sleep(2000);
		AndroidElement searchBtn = driver.findElement(By.xpath("//android.widget.Button[@text='search']"));
		if (!searchBtn.isDisplayed()) {
			assert false;
		}
		
		List<AndroidElement> alltextinchallenges = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement el : alltextinchallenges) {

			if (el.getText().equals("Game Play and Earn from EVM Network")) {
				System.out.println("Proposal search doesn't work");
				Reporter.log("Proposal search doesn't work");
				assert false;
				// Thread.sleep(2000);

			}
		}
		AndroidElement clearButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Clear All']"));
		clearButton.click();
		Thread.sleep(2000);
	}

	public AndroidDriver<AndroidElement> driverReturn() {
		System.out.println("return driver method");
		return (driver);
	}

	public void goToChallenge() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<AndroidElement> alltextinproposal = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement el : alltextinproposal) {

			if (el.getText().equals("The Great Migration (from Ethereum)")) {
				el.click();
				System.out.println("Тest is in Great Migration");
				Reporter.log("Тest is in Great Migration");
				break;
				// Thread.sleep(2000);

			}
		}
	}

	public void proposalFiltering() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("test is in challenge");
		Thread.sleep(2000);
		AndroidElement loveSign = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.view.View/android.widget.Image"));
		loveSign.click();

		List<AndroidElement> alltextView = driver.findElements(By.className("android.widget.TextView"));
		List<AndroidElement> allproposal = driver.findElements(By.className("android.widget.RadioGroup"));
		List<AndroidElement> allradioButton = driver.findElements(By.className("android.widget.RadioButton"));
		List<AndroidElement> allwidgetButton = driver.findElements(By.className("android.widget.Button"));

		int i = 0;

		for (AndroidElement elm : alltextView) {
			System.out.println(elm.getText());
			Reporter.log(elm.getText());

		}

		for (AndroidElement filter : allwidgetButton) {
			if (filter.getText().equals("Filter")) {
				filter.click();
			}
		}
		AndroidElement hartSign = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.RadioButton"));
		hartSign.click();
		AndroidElement apply = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));
		apply.click();
		int visibleStars = 0;
		Thread.sleep(4000);
		List<AndroidElement> numberOfView = driver.findElements(By.className("android.widget.Image"));
		for (AndroidElement image : numberOfView) {
			image.getText();
			System.out.println("This is text of images");
			System.out.println("Size of images is: " + " " + numberOfView.size());

		}
		assertEquals(numberOfView.size(), 3);
	}

	public void oneProposalCannotMoveLeftAndRight() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		// List<AndroidElement> loveSignFind =
		// driver.findElements(By.className("android.widget.Image"));
		AndroidElement goInFilteredProposal = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[5]/android.view.View"));
		goInFilteredProposal.click();
		AndroidElement allowRight = driver
				.findElement(By.xpath("//android.widget.Image[@text='arrow-right-disabled.df1d643a']"));
		AndroidElement allowLeft = driver
				.findElement(By.xpath("//android.widget.Image[@text='arrow-left-disabled.b4a647ea']"));
		AndroidElement nameOfProposal = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Community CIP Editor: 1 year budget']"));
		allowRight.click();
		if (!nameOfProposal.isDisplayed()) {
			assert false;
		}
		allowLeft.click();
		if (!nameOfProposal.isDisplayed()) {
			assert false;
		}
	}

	public void userCanVoteYesOrNo() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"icon thumb down\").instance(0))";

		driver.findElementByAndroidUIAutomator(scrollElement);

		AndroidElement voteDown = driver.findElement(By.xpath("//android.widget.Button[@text='icon thumb down']"));
		AndroidElement voteUp = driver.findElement(By.xpath("//android.widget.Button[@text='icon thumb up']"));

		if (!voteDown.isDisplayed() || !voteUp.isDisplayed()) {
			assert false;
		}

	}

	public void backToChallenge() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Back to Challenge\").instance(0))";

		driver.findElementByAndroidUIAutomator(scrollElement);
		Thread.sleep(2000);
		AndroidElement backToChallengeButton = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Back to Challenge']"));
		backToChallengeButton.click();
	}

	public void clearFilter() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AndroidElement clearFilter = driver.findElement(By.xpath("//android.widget.TextView[@text='Clear All']"));
		List<AndroidElement> numberOfImages = driver.findElements(By.className("android.widget.Image"));
		for (AndroidElement image : numberOfImages) {
			image.getText();
			System.out.println("This is text of images");
		}

		System.out.println("Size of images is: " + " " + numberOfImages.size());
		assertEquals(numberOfImages.size(), 3);

		clearFilter.click();
		Thread.sleep(2000);
		List<AndroidElement> numberOfImagesAfterFilterClear = driver.findElements(By.className("android.widget.Image"));
		for (AndroidElement image : numberOfImages) {
			image.getText();
		}
		System.out.println("Size of images is: " + " " + numberOfImagesAfterFilterClear.size());
		if (numberOfImages.size() == numberOfImagesAfterFilterClear.size()) {
			assert false;
		}
	}

	public void moreProposalsCanMoveLeftAndRight() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		AndroidElement goInFilteredProposal = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.view.View"));
		goInFilteredProposal.click();
		Thread.sleep(1000);
		AndroidElement allowRight = driver
				.findElement(By.xpath("//android.widget.Image[@text='arrow-right-primary.57ffea5c']"));
		AndroidElement nameOfProposal = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Community CIP Editor: 1 year budget']"));

		allowRight.click();
		AndroidElement nameOfProposalAfterClickRight = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Game Play and Earn from EVM Network']"));
		if (!nameOfProposalAfterClickRight.isDisplayed()) {
			assert false;
		}
		AndroidElement allowLeft = driver
				.findElement(By.xpath("//android.widget.Image[@text='arrow-left-primary.cce43d35']"));
		allowLeft.click();
		Thread.sleep(1000);
		if (!nameOfProposal.isDisplayed()) {
			assert false;
		}
	}

	public void advisorScore() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		AndroidElement goInFilteredProposal = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.view.View"));
		goInFilteredProposal.click();
		Thread.sleep(2000);
		AndroidElement advisorScore = driver.findElement(By.xpath("//android.widget.TextView[@text='ADVISOR SCORE']"));
		AndroidElement advisorScoreLink = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Read Advisors Reviews (6)']"));

		if (!advisorScore.isDisplayed() || !advisorScoreLink.isDisplayed()) {
			assert false;
		}
		advisorScoreLink.click();
		Thread.sleep(2000);

		AndroidElement backToProposalDetailButton = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Back to Proposal Detail']"));
		AndroidElement iconInfoButton = driver.findElement(By.xpath("//android.widget.Image[@text='Icon Info']"));
		if (!advisorScore.isDisplayed() || !advisorScoreLink.isDisplayed() || !backToProposalDetailButton.isDisplayed()
				|| iconInfoButton.isDisplayed()) {
			assert false;
		}
		iconInfoButton.click();
		Thread.sleep(2000);
		AndroidElement infoButton = driver.findElement(By.xpath("//android.widget.TextView[@text='INFO']"));
		if (!infoButton.isDisplayed()) {
			assert false;
		}
		backToProposalDetailButton.click();
		Thread.sleep(2000);
		if (!backToProposalDetailButton.isDisplayed()) {
			assert false;
		}
	}

}
