package io.testomat.e2e_tests_light_1.selenium.common;

import io.testomat.e2e_tests_light_1.selenium.web.pages.LoginPageSelenium;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;

public class LoginTestomatExtension implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        driver().get("https://app.testomat.io/");
        driver().manage().window().maximize();

        new LoginPageSelenium().login("kozar.vasyl@gmail.com", "eit9E$Ta'N@IFJ{");
    }
}
