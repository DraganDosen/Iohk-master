package Pages;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class CastVotesPage extends BasePage {
	
	//public class MySelectionPage extends BasePage {
		
		AndroidDriver<AndroidElement> driver;
		public WebDriverWait wait;
		
		public CastVotesPage(AndroidDriver<AndroidElement> driver) {
			// super(driver);
			this.driver = driver;
			// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		public void goCastVotes() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			AndroidElement goToCastVoites = driver.findElement(By.xpath("\r\n"
					+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.view.View[4]"));
			goToCastVoites.click();

			Thread.sleep(3000);

			List<AndroidElement> verifyCastVotes = driver.findElements(By.className("android.widget.TextView"));
			for (AndroidElement vrfcstVotes : verifyCastVotes) {

				System.out.println(vrfcstVotes.getText());
				if (vrfcstVotes.getText().equals("Cast Votes")) {
					assertEquals(vrfcstVotes.getText(), "Cast Votes");
					System.out.println("View Cast Votes is visible");
					Reporter.log("View Cast Votes is visible");
					
					List<AndroidElement> emptyCastVotes=driver.findElements(By.className("android.widget.TextView"));
					for (AndroidElement emptyVotes : emptyCastVotes) {
						if (emptyVotes.getText().equals("No votes cast")) {
							System.out.println("Cast Votes is empty");
							Reporter.log("Cast Votes is empty");
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
					System.out.println("Тest is out of Cast Votes");
					Reporter.log("Тest is out of Cast Votes");
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
