package Testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"classpath:feature/Nationality.feature"}
,glue= {"Cucumber5"},
plugin = {"pretty", "html:target/cucumber-html-report"},
//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
tags = {}
)
public class runner {

}
