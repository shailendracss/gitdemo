package tests;

import org.testng.annotations.Test;

import com.configData_Util.STATUS;
import com.customReporting.CustomReporter;

public class Sequential {

	@Test(priority=0,description = "ADARSH1")
	public void Test1_S() throws InterruptedException {
		Thread.sleep(5000);
		CustomReporter.report(STATUS.PASS, "ADARSH1 - STEP 1.1");
		CustomReporter.report(STATUS.INFO, "ADARSH1 - STEP 1.2");
		CustomReporter.report(STATUS.WARNING, "ADARSH1 - STEP 1.3");
		CustomReporter.report(STATUS.PASS, "ADARSH1 - STEP 1.4");
		CustomReporter.report(STATUS.PASS, "ADARSH1 - STEP 1.5");
		CustomReporter.report(STATUS.PASS, "ADARSH1 - STEP 1.6");
	}
	
	@Test(priority=1,description = "ADARSH2")
	public void Test2_S() throws InterruptedException {
		Thread.sleep(5000);
		CustomReporter.report(STATUS.PASS, "ADARSH2 - STEP 1");
		CustomReporter.report(STATUS.INFO, "ADARSH2 - STEP 2");
		CustomReporter.report(STATUS.WARNING, "ADARSH2 - STEP3");
		CustomReporter.report(STATUS.PASS, "ADARSH2 - STEP 4");
		CustomReporter.report(STATUS.PASS, "ADARSH2 - STEP 5");
		CustomReporter.report(STATUS.PASS, "ADARSH2 - STEP 6");
	}

}
