package io.testomat.e2e_tests_light_1.selenium.web.pages;

import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;

public class LoginPageSelenium {

    public void login(String username, String password) {
        find("#content-desktop #user_email").sendKeys(username);
        find("#content-desktop #user_password").sendKeys(password);
        find("#content-desktop #user_remember_me").click();
        find("#content-desktop [type=\"submit\"]").click();

    }
}
