package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/java/features",
glue={"stepDefination"},
plugin= {"pretty","html:report","json:json_object/cucumber.json","junit:test/cucumbe.xml"}
)

public class TestRunner {

}
