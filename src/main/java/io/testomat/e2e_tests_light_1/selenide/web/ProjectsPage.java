package io.testomat.e2e_tests_light_1.selenide.web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private final SelenideElement searchInput = $("[id='search']");

    public void open() {
        Selenide.open("");
    }

    public ProjectsPage searchForProject(String targetProjectName) {
        searchInput.setValue(targetProjectName);

        return this;
    }

    public ProjectsPage selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();

        return this;
    }

    public void isSignInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
    }

    public ProjectsPage isLoaded() {
        searchInput.shouldBe(visible);

        return this;
    }

    @NotNull
    public ElementsCollection countOfProjectsShouldBeEqualsTo(int expectedSize) {
        return $$("#grid ul li").filter(visible).shouldHave(size(expectedSize));
    }

    public void countTestCasesShouldBeEqualsTo(SelenideElement targetProject, int expectedCount) {

        targetProject.shouldHave(text(expectedCount + " tests"));
    }

    public int countVisibleProjectsOnPage() {
        ElementsCollection liElements = $(".tab-content > ul").$$("li");

        int visibleCount = 0;
        for (SelenideElement liElement : liElements) {
            if (liElement.isDisplayed()) {
                visibleCount++;
            }
        }

        return visibleCount;
    }
}
