import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").pressEnter();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем, чтобы Issues с номером #" + ISSUE_NUMBER + " была видна", () -> {
            $(withText("#" + ISSUE_NUMBER)).shouldBe(Condition.visible);
        });

    }
}
