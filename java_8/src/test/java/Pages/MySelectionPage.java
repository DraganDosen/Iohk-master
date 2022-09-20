package Pages;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MySelectionPage extends BasePage {

	AndroidDriver<AndroidElement> driver;
	public WebDriverWait wait;

	public MySelectionPage(AndroidDriver<AndroidElement> driver) {
		// super(driver);
		this.driver = driver;
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void goMySelection() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement goToMySelection = driver.findElement(By.xpath("\r\n"
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]"));
		goToMySelection.click();

		List<AndroidElement> verifyMySelection = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement vrfmysel : verifyMySelection) {

			System.out.println(vrfmysel.getText());
			if (vrfmysel.getText().equals("My Selection")) {
				assertEquals(vrfmysel.getText(), "My Selection");
				System.out.println("View My Selection is visible");
				Reporter.log("View My Selection is visible");

				List<AndroidElement> emptyMySel = driver.findElements(By.className("android.widget.TextView"));
				for (AndroidElement emptMySel : emptyMySel) {
					if (emptMySel.getText().equals("No votes selected")) {
						System.out.println("No votes selected");
						Reporter.log("No votes selected");
					}

				}
				break;
			}
			Thread.sleep(2000);
		}

		List<AndroidElement> goBackFind = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement gobck : goBackFind) {

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

	public AndroidDriver<AndroidElement> driverReturn() {
		System.out.println("return driver method");
		return (driver);
	}
}
