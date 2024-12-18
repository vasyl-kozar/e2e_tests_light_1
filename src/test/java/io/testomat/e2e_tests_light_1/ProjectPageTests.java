package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.e2e_tests_light_1.utils.StringParsesrs.getNumberFromText;

public class ProjectPageTests extends BaseTest {

    static String baseURL = env.get("BASE_URL");
    static String userEmail = env.get("USEREMAIL");
    static String userPassword = env.get("USERPASSWORD");
    String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        open(baseURL);

        loginUser(userEmail, userPassword);
    }

    @BeforeEach
    void OpenHomePage() {
        open(baseURL);
    }

    @Test
    public void userCanFindProjectWithTests() {

        searchForProject(targetProjectName);

        selectProject(targetProjectName);

        waitForProjectPageIsLoaded(targetProjectName);
    }

    @Test
    public void checkProjectTestCasesNumberTest() {

        searchForProject(targetProjectName);

        SelenideElement targetProject = countOfProjectsShouldBeEqualsTo(1).first();

        countTestCasesShouldBeEqualsTo(targetProject, 0);
    }

    private static void waitForProjectPageIsLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    private static void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    private static void searchForProject(String targetProjectName) {
        $("[id='search']").setValue(targetProjectName);
    }

    private void countTestCasesShouldBeEqualsTo(SelenideElement targetProject, int expectedCount) {

        targetProject.$("span").shouldHave(text("Classical"));
        String countOfTests = targetProject.$("p").getText();

        Assertions.assertEquals(expectedCount, getNumberFromText(countOfTests));
    }

    @NotNull
    private static ElementsCollection countOfProjectsShouldBeEqualsTo(int expectedSize) {
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
