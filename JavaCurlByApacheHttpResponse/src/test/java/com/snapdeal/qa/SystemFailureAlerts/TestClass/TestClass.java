/**
 * 
 */
package com.snapdeal.qa.SystemFailureAlerts.TestClass;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.snapdeal.qa.SystemFailureAlerts.Util.SendEmail;
import com.snapdeal.qa.SystemFailureAlerts.providerSytems.Cams;

/**
 * @author mohammad.akhtar
 */
public class TestClass {
	private ArrayList<String> failedSystems = new ArrayList<>();
	private Cams cams = null;

	@BeforeClass
	public void beforeClass() {
		cams = new Cams();
	}

	@AfterClass
	public void AfterClass() {
		if (failedSystems.size() > 0)
			SendEmail.sendEmail(failedSystems, "mohammad.akhtar@snapdeal.com");
	}

	@Test(description = "Test for the cams running status.")
	public void checkForCams() {
		if (!cams.getAllLabels())
			failedSystems.add("Cams");
	}
}
