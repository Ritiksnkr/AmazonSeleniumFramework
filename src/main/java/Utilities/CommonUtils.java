package Utilities;

import org.testng.SkipException;

public class CommonUtils {
	// function toCheckExecutionRequired
	public static void toCheckExecutionRequired(String executionRequired) {

		// if execution required field is no
		if (executionRequired.toLowerCase().equals("no")) {

//			extentTest.log(LogStatus.WARNING, "Execution Required : "+executionRequired.toUpperCase());
//			logger.info("Execution required is no , skipping the test");
			throw new SkipException("Skipping this exception");
		}

		// if execution required field is empty
		if (executionRequired.equals("")) {

//			extentTest.log(LogStatus.WARNING, "Execution Required : "+executionRequired.toUpperCase());
//			logger.info("Execution required is empty , skipping the test");
			throw new SkipException("Skipping this exception");
		}
	}

}
