package Steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/ressources/Features"},
        glue = {"Steps"}
)
public class RunnerTest {
}