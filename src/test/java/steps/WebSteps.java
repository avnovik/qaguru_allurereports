package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем, чтобы Issues с номером {issueNumber} была видна")
    public void shouldSeeIssueWithNumber(int issueNumber) {
        $(withText("#" + issueNumber)).shouldBe(Condition.visible);
    }
}
