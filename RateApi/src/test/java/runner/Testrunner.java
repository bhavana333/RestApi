package runner;



import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"src/test/java/features"}
,glue= {"gluecode"},
plugin={"html:src/reports/rep1.html","junit:src/reports/rep1.xml","json:src/reports/rep2.json"}
)

public class Testrunner {

}







