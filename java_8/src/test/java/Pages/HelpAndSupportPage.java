package Pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import io.appium.java_client.pagefactory.AndroidFindBy;
import android.SecretsKeys;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

public class HelpAndSupportPage {
	
	AndroidDriver<AndroidElement> driver;
	public WebDriverWait wait;
	public HelpAndSupportPage(AndroidDriver<AndroidElement> driver) {
		//super(driver);
		this.driver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	

}
