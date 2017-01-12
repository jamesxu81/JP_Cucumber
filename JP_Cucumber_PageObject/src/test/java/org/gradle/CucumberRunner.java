package org.gradle;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

// This is Cucumber Test
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-html-report"},
        features = {"src/test/resources/features"},
        tags = {"@base_flow"},
        glue = "glue" )

public class CucumberRunner {
}