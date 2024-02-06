
package com.appium.runners;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = { "pretty", "html:target_TestNG/Pixel_3/cucumber-report.html", "summary"
		// "de.monochromata.cucumber.report.PrettyReports:target/Pixel_3/cucumber-html-reports"}
		, "me.jvt.cucumber.report.PrettyReports:target_TestNG/Pixel_3/" }, features = {
				"src/test/resources/features" }, glue = {
						"com.appium.stepDefinitions" }, dryRun = false, monochrome = true
// ,strict=true
		, tags = "@login-feature")
public class TestNGRunner_Pixel3 extends RunnerBase {
}