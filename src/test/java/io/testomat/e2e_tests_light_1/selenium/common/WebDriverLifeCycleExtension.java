package io.testomat.e2e_tests_light_1.selenium.common;

import io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WebDriverLifeCycleExtension implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        WebDriverProvider.driver();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        WebDriverProvider.quitDriver();
    }
}
