package io.testomat.e2e_tests_light_1.selenide.web;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public void isLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    public ProjectPage openReadme() {
        $(Selectors.byLinkText("Readme")).click();

        return this;
    }

    public ProjectPage clickOnEdit() {
        $(Selectors.byLinkText("Edit")).click();

        return this;
    }
}
