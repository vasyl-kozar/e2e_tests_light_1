package io.testomat.e2e_tests_light_1.selenium.web.common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Waits {

    private final By selector;
    private final WebDriverWait wait;

    public Waits(By selector) {
        this.selector = selector;
        this.wait = new WebDriverWait(WebDriverProvider.driver(), Duration.ofSeconds(10));
        this.wait.pollingEvery(Duration.ofMillis(100));
    }

    public void visibility() {
        this.wait.until(visibilityOfElementLocated(this.selector));
    }

    public void isHidden() {
        this.wait.until(invisibilityOfElementLocated(this.selector));
    }

    public void hasText(String expectedText) {
        this.wait.until(ExpectedConditions.textToBe(selector, expectedText));
    }

    public void containsText(String expectedText) {
        this.wait.until(ExpectedConditions.textMatches(
                selector, Pattern.compile(
                        Pattern.quote(expectedText),
                        Pattern.CASE_INSENSITIVE
                )
        ));
    }
}
