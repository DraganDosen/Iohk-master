package Pages;
import java.util.List;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.pagefactory.AndroidFindBy;
import android.SecretsKeys;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
public  class BasePage {
	//public AndroidDriver<AndroidElement> driver;
	//public WebDriverWait wait;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View")
	private AndroidElement alltextOnScreenHR;
	
	/*public BasePage (AndroidDriver<AndroidElement> driver) {
		if (driver !=null) {
			this.driver = driver;
			wait = new WebDriverWait (driver, 30);
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	}	*/
		public  static String widgetbutton = "android.widget.Button";
		public  static String widgetTextView = "android.widget.TextView";
		public static String readyToPaste = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.Button";
		public static void equals( List<AndroidElement> elone, List<AndroidElement> eltwo) {
			org.junit.Assert.assertEquals(elone, eltwo);
			
		}
		
/*	public void ConnectWallet() throws InterruptedException {
		SecretsKeys key = new SecretsKeys();
		Thread.sleep(3000);
		System.out.println("Connect to vote must be visible!!!");
	    
		//AndroidElement alltextOnScreenHR = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View"));
		List<AndroidElement> conButtons = driver.findElements(By.className("android.widget.Button"));
		for (AndroidElement el : conButtons) {

			System.out.println(el.getText());
			if (el.getText().equals("CONNECT WALLET")) {
				Thread.sleep(2000);
				el.click();

				System.out.println("wallet is clicked");
			}
			Thread.sleep(5000);
		}
		
		System.out.println("+*'+*'+*?");
		alltextOnScreenHR.click();

		// WebDriverWait waitme;

		
		Thread.sleep(1000);
		
		System.out.println("Yoroi mobile is clicked!");

		List<AndroidElement> alltextOnScreen = driver.findElements(By.className("android.widget.Button"));
		for (AndroidElement el : alltextOnScreen) {
			System.out.println(el.getText());
			if (el.getText().equals("I'M READY TO PASTE MY HASH CODE")) {
				Thread.sleep(2000);
				el.click();

				System.out.println("CLICKED ON READY TO PASTE");
			}

		}

		AndroidElement readyToPasteHC = driver.findElement(By.xpath("\r\n"
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.Button"));
		readyToPasteHC.click();
		AndroidElement editText = driver.findElement(By.className("android.widget.EditText"));
		editText.sendKeys(key.walletkey);
		AndroidElement confirmButton = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button"));
		confirmButton.click();
		List<AndroidElement> alltextOnScreen1 = driver.findElements(By.className("android.widget.TextView"));
		for (AndroidElement el : alltextOnScreen1) {
			System.out.println(el.getText());

		}
		List<AndroidElement> enterPinFieds = driver.findElements(By.className("android.widget.EditText"));
		int i = 1;
		for (AndroidElement el : enterPinFieds) {
			
			System.out.println(i);
			el.click();
			Thread.sleep(1000);
			el.sendKeys(String.valueOf(i));
			i = i + 1;
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		AndroidElement confirm = driver.findElement(By.className("android.widget.Button"));
	     confirm.click();
	     Thread.sleep(2000);
	    
	     AndroidElement got = driver.findElement(By.className("android.widget.Button"));
	     got.click();
	     Thread.sleep(2000);
	     List<AndroidElement> walletConectedTexts = driver.findElements(By.className("android.widget.TextView"));
			
			for (AndroidElement el : walletConectedTexts) {
				System.out.println(el.getText());

			}
			got.click();
			 Thread.sleep(5000);
		// Invoke driver.quit() after the test is done to indicate that the test is
		// completed.
	} */

	
}


