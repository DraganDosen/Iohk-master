package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.Reporter;
import org.openqa.selenium.Alert;
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

public class SmokeTestPage extends BasePage {
//public class DashboardPage {
	AndroidDriver<AndroidElement> driver;
	public WebDriverWait wait;

	public SmokeTestPage(AndroidDriver<AndroidElement> driver) {
		// super(driver);
		this.driver = driver;
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public AndroidDriver<AndroidElement> driverReturn() {
		System.out.println("return driver method");
		return (driver);
	}

	public void buttonSkip() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("***skip button method***");
		Reporter.log("skip button method ");
		AndroidElement buttonSkip = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));
		System.out.println(buttonSkip.getText());
		buttonSkip.click();

		Thread.sleep(1000);

	}

	public void checkDashboard() throws InterruptedException {
		// Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Thread.sleep(2000);

		ArrayList<String> listOfTextViewforComparing = new ArrayList();
		ArrayList<String> listOfTextView = new ArrayList();
		listOfTextView.add("Fund9");
		listOfTextView.add("Welcome to Catalyst!");
		listOfTextView.add("Your votes decide which project ideas get funding to solve real world problems.");
		listOfTextView.add("To vote, please CONNECT A REGISTERED WALLET.");
		listOfTextView.add("Take a look at the Voter Guide!");
		listOfTextView.add("Voting Power");
		// listOfTextView.add(
		// "Voting power comes from the balance snapshot Aug 4th, 2022 11:00 UTC and
		// will display how much Voting Power you have only once voting starts.");
		listOfTextView.add("How does it work?");
		// listOfTextView.add("Voting has started!");
		// listOfTextView.add("02 : 10 : 16 : 15");
		// listOfTextView.add("Majmun");
		listOfTextView.add("Dashboard");
		listOfTextView.add("Proposals");
		listOfTextView.add("My Selection");
		listOfTextView.add("Cast Votes");
		listOfTextView.add("Help & Support");

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.TextView")));
		List<AndroidElement> alltextview = driver.findElements(By.className("android.widget.TextView"));

		for (AndroidElement el : alltextview) {
			Reporter.log(el.getText());
			System.out.println(el.getText());
			listOfTextViewforComparing.add(el.getText());
		}

		System.out.println("first list: ");
		listOfTextView.forEach(System.out::println);
		System.out.println("second list: ");
		listOfTextViewforComparing.forEach(System.out::println);

		boolean a;
		a = listOfTextViewforComparing.containsAll(listOfTextView);
		if (a) {
			System.out.println(a);
			System.out.println("Dashboard has all text as expected!***");
			Reporter.log("Dashboard has all text as expected!");
		} else {
			System.out.println("Dashboard has нот all text as expected!***");
			Reporter.log("Dashboard has not all text as expected!");
			assert false;
		}
	}

	public void goHelpAndSupport() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement goHelpAndSupport = driver.findElement(By.xpath("\r\n"
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.view.View[5]"));
		goHelpAndSupport.click();

		Thread.sleep(2000);

		List<AndroidElement> verifyHelpAndSupport = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement vrfcstVotes : verifyHelpAndSupport) {

			System.out.println(vrfcstVotes.getText());
			if (vrfcstVotes.getText().equals("Help & Support")) {
				assertEquals(vrfcstVotes.getText(), "Help & Support");
				System.out.println("View Help & Support is visible");
				Reporter.log("View Help & Support is visible");
				break;
			}
			Thread.sleep(2000);
		}

		List<AndroidElement> goBack = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement gobck : goBack) {

			System.out.println(gobck.getText());
			if (gobck.getText().equals("Back")) {
				gobck.click();
				System.out.println("test is out of Help and Support");
				Reporter.log("Тest is out of Help and Support");
				break;

			}
			Thread.sleep(3000);
		}
	}

	public void goMySelection() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement goToProposal = driver.findElement(By.xpath("\r\n"
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]"));
		goToProposal.click();

		List<AndroidElement> verifyMySelection = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement vrfmysel : verifyMySelection) {

			System.out.println(vrfmysel.getText());
			if (vrfmysel.getText().equals("My Selection")) {
				assertEquals(vrfmysel.getText(), "My Selection");
				System.out.println("View My Selection is visible");
				Reporter.log("View My Selection is visible");
				break;
			}
			Thread.sleep(2000);
		}

		List<AndroidElement> goBack = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement gobck : goBack) {

			System.out.println(gobck.getText());
			if (gobck.getText().equals("Back")) {
				gobck.click();
				System.out.println("Тest is out of My Selection");
				Reporter.log("Тest is out of My Selection");
				break;

			}
			Thread.sleep(2000);
		}
	}

	public void enrollButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<AndroidElement> allButtons = driver.findElements(By.className("android.widget.Button"));
		for (AndroidElement el : allButtons) {

			System.out.println(el.getText());
			if (el.getText().equals("ENROLL TO RECEIVE NOTIFICATIONS")) {
				Thread.sleep(2000);
				el.click();
				Thread.sleep(2000);
			}
		}
		int i = 0;
		int j = 0;
		for (i = 0; i < 15 && j != 10; i++) {
			Thread.sleep(1000);
			System.out.println(i);
			List<AndroidElement> alltextview = driver.findElements(By.className("android.widget.TextView"));
			for (AndroidElement elem : alltextview) {
				// System.out.println(i);
				System.out.println(elem.getText());
				if (elem.getText().equals("Fund9")) {
					// System.out.println("Test is in ENROLL or loader is still visible!");
					j = 10;

				}

			}

		}
	}

	public void closePopup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<AndroidElement> closepopup = driver.findElements(By.className("android.widget.Image"));
		for (AndroidElement el : closepopup) {

			System.out.println(el.getText());
			if (el.getText().equals("notifications icon")) {
				el.click();
				System.out.println("Popup is moved");
				Reporter.log("Popup is moved");
				break;
			}

		}
	}

}
