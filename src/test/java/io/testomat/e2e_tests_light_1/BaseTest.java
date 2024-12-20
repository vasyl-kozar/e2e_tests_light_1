package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.github.cdimascio.dotenv.Dotenv;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.testomat.e2e_tests_light_1.utils.StringParsesrs.getNumberFromText;

public class BaseTest {
    static Dotenv env = Dotenv.load();
    static String baseURL = env.get("BASE_URL");
    static String userEmail = env.get("USEREMAIL");
    static String userPassword = env.get("USERPASSWORD");

    protected static int countVisibleProjectsOnPage() {
        ElementsCollection liElements = $(".tab-content > ul").$$("li");

        int visibleCount = 0;
        for (SelenideElement liElement : liElements) {
            if (liElement.isDisplayed()) {
                visibleCount++;
            }
        }

        return visibleCount;
    }

    protected static void waitForProjectPageIsLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    protected static void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    protected static void searchForProject(String targetProjectName) {
        $("[id='search']").setValue(targetProjectName);
    }

    protected void countTestCasesShouldBeEqualsTo(SelenideElement targetProject, int expectedCount) {

        targetProject.$("span").shouldHave(text("Classical"));
        String countOfTests = targetProject.$("p").getText();

        Assertions.assertEquals(expectedCount, getNumberFromText(countOfTests));
    }

    @NotNull
    protected static ElementsCollection countOfProjectsShouldBeEqualsTo(int expectedSize) {
        return $$("#grid ul li").filter(visible).shouldHave(size(expectedSize));
    }

    public static void loginUser(String email, String password) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [type=\"submit\"]").click();
        $(".common-flash-success").shouldBe(visible);
    }
}
