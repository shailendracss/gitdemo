package or.imail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.SeleniumMethods;

public class Imail_Dashboard {
	public static final String title = "admin/imail/dashboard";

	@FindBy(xpath = "//a/h4[contains(.,'External Imail')]")
	private WebElement link_External_Imail;
	
	@FindBy(xpath = "//a/h4[contains(.,'Internal Imail')]")
	private WebElement link_Internal_Imail;
	 
	private SeleniumMethods com;
	
	public Imail_Dashboard() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}

	/**
	 * Use this to verify UI of Imail Dashboard Page
	 * */
	public void verifyUI() {
		com.isElementPresent(link_External_Imail, "External_Imail Center Link");
		com.isElementPresent(link_Internal_Imail, "Internal_Imail Center Link");
	}
	
}
