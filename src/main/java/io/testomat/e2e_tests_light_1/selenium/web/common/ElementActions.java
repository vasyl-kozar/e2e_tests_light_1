package io.testomat.e2e_tests_light_1.selenium.web.common;

import org.openqa.selenium.By;

import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;

public class ElementActions {
    private final By selector;

    public ElementActions(By selector) {
        this.selector = selector;
    }

    public void click() {
        waitFor().visibility();
        driver().findElement(selector).click();
    }

    public void sendKeys(String text) {
        waitFor().visibility();
        driver().findElement(selector).sendKeys(text);
    }

    public Waits waitFor() {
        return new Waits(this.selector);
    }
}
