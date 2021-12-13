import org.junit.jupiter.api.Test;
import steps.WebSteps;

public class StepAnnotatedTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    private final WebSteps steps = new WebSteps();

    @Test
    public void stepAnnotation() {
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
