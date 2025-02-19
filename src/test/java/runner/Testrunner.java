package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "seleniumgluecode",
        monochrome = true,
        plugin = {"pretty", "summary"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class Testrunner {
}
