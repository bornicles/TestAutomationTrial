package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {


    public void createReports() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./ExtentReports");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        ExtentTest logger = extent.createTest("Test");
        logger.log(Status.INFO,"testing");

        extent.flush();

    }

}
