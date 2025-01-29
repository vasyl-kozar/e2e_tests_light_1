package io.testomat.e2e_tests_light_1.selenide.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ReadmePage {

    private final SelenideElement firstLineInEditor = $("[class*='view-lines'] span[class*='mtk6']:last-child");
    private final SelenideElement frameElement = $("#modal-overlays iframe[src='/ember-monaco/frame.html']");

    public ReadmePage clickOnEditReadme() {
        $(Selectors.byText("Edit Readme")).click();
        Selenide.switchTo().frame(frameElement);

        return this;
    }

    public ReadmePage editFirstLineInEditor(String targetText) {
        firstLineInEditor.shouldBe(Condition.visible);

        executeJavaScript("arguments[0].textContent = arguments[1];", firstLineInEditor, targetText);

        return this;
    }

    public ReadmePage isFirstLineEdited(String targetText) {
        $(Selectors.byText("Edit Readme")).click();
        Selenide.switchTo().frame(frameElement);

        firstLineInEditor.shouldHave(Condition.text(targetText));

        return this;
    }

    public ReadmePage clickOnUpdate() {
        Selenide.switchTo().defaultContent();
        $(Selectors.byText("Update")).click();

        return this;
    }

    public ReadmePage clickOnCancel() {
        Selenide.switchTo().defaultContent();
        $(Selectors.byText("Cancel")).click();

        return this;
    }

    public ReadmePage isLoaded() {
        $("h2").shouldHave(Condition.text("Readme"));

        return this;
    }
}
